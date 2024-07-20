package org.hzz.learning.application.handler.lesson;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.lesson.LearnRecordCommitCommand;
import org.hzz.learning.application.handler.MarkConstants;
import org.hzz.learning.application.task.impl.RecordDelayTaskHandler;
import org.hzz.learning.domain.aggregate.LearnLessonAggregate;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.types.enums.lesson.LessonStatus;
import org.hzz.learning.types.enums.lesson.SectionType;
import org.hzz.learning.domain.service.lesson.LearnLessonDomainService;
import org.hzz.learning.domain.service.lesson.LearnLessonRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 处理学习记录提交
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Component
@Slf4j
public class LearnRecordCommitCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LearnRecordCommitCommand, Object> {

    @Setter(onMethod_ = @Autowired)
    private LearnLessonRecordDomainService learnLessonRecordDomainService;
    @Setter(onMethod_ = @Autowired)
    private LearnLessonDomainService learnLessonDomainService;

    @Setter(onMethod_ = @Autowired)
    private RecordDelayTaskHandler taskHandler;

    @Override
    public String mark() {
        return MarkConstants.LEARN_LESSON_RECORD_COMMIT;
    }

    @Override
    @Transactional
    public void execute(LearnRecordCommitCommand command) {
        boolean finished = false;
        if (SectionType.EXAM == command.getSectionType()) {
            // 处理考试
            handleExamRecord(command);
        } else if (SectionType.VIDEO == command.getSectionType()) {
            // 处理视频
            handeVideoRecord(command);
        }

        // 处理课表
        //handleLearnLesson(command,finished);
    }

    /**
     * 处理课程表
     * 最近学习小节
     * 最近学习时间
     * 整个课程是否学完
     * 已学课程小节数量
     * @param command 命令参数
     * @param finished 小节是否学习完成
     */
    void handleLearnLesson(LearnRecordCommitCommand command,boolean finished){
        // 课程数据
        LearnLessonAggregate learnLessonAggregate = learnLessonDomainService.getLearnLessonAggregate(command.getLessonId());
        LearningLessonEntity lessonEntity = learnLessonAggregate.getLearningLesson();
        CourseEntity courseEntity = learnLessonAggregate.getCourseEntity();

        // 最近学习小节
        lessonEntity.setLatestSectionId(command.getSectionId());
        // 最近学习时间
        lessonEntity.setLatestLearnTime(command.getCommitTime());

        if(finished){
            // 已完成小节数+1
            lessonEntity.setLearnedSections(lessonEntity.getLearnedSections() + 1);
            // 设置课程的状态
            if(lessonEntity.getLearnedSections() >= courseEntity.getSectionNum()){
                // 设置整个课程已经学完
                lessonEntity.setLessonStatus(LessonStatus.FINISHED);
            }else{
                // 正在学习
                lessonEntity.setLessonStatus(LessonStatus.LEARNING);
            }
        }
        learnLessonDomainService.updateLessonSelectiveById(lessonEntity);
    }

    /**
     * 处理考试记录
     *
     * @param command 命令
     * @return true 表示已经完成该小节
     */
    void handleExamRecord(LearnRecordCommitCommand command) {
        boolean finished = true;
        LearnRecordEntity entity = new LearnRecordEntity();

        entity.setUserId(command.getUserId())
                .setFinished(finished)
                .setFinishTime(LocalDateTime.now())
                .setLessonId(command.getLessonId())
                .setSectionId(command.getSectionId());

        learnLessonRecordDomainService.commitRecord(entity);
        handleLearnLesson(command,true);
    }

    /**
     * 处理视频记录
     * 如果学习完成直接保存数据库
     * 持续学习只是更新时长，那么使用redis处理，只保留最后一次即可
     * @param command
     * @return 是否学完
     */
    void handeVideoRecord(LearnRecordCommitCommand command) {
        // 获取记录lessonId,sectionID
        LearnRecordEntity oldRecord = learnLessonRecordDomainService.findLearnRecord(command.getLessonId(), command.getSectionId());
        boolean finished = false;
        if (oldRecord == null) {
            // 插入一条新记录
            LearnRecordEntity entity = new LearnRecordEntity();
            entity.setLessonId(command.getLessonId())
                    .setUserId(command.getUserId())
                    .setSectionId(command.getSectionId())
                    .setFinished(finished)
                    .setMoment(command.getMoment());
            learnLessonRecordDomainService.commitRecord(entity);
        } else {
            // 继续学习
            // 更新存在的记录
            if (oldRecord.getFinished()) {
                // 学习完之后又继续学习，这时候需要保存视频进度
                oldRecord.setMoment(command.getMoment());
                learnLessonRecordDomainService.updateRecord(oldRecord);
                handleLearnLesson(command,false);
            }else{
                // 判断是否是并且观看视频进度大于90%
                finished = command.getMoment() * 1.1 > command.getDuration();
                if(!finished){
                    // 对于持续提交的,交给延迟任务做缓存判断
                    oldRecord.setMoment(command.getMoment());
                    // learnLessonRecordDomainService.updateRecord(oldRecord);
                    // 添加延迟任务
                    taskHandler.addLearningRecordTask(oldRecord);
                    // 直接结束，不更新课表
                    return;
                }else{
                    // 第一次学完
                    oldRecord.setMoment(command.getMoment())
                            .setFinished(finished)
                            .setFinishTime(command.getCommitTime());
                    learnLessonRecordDomainService.updateRecord(oldRecord);
                    // 清除缓存
                    taskHandler.cleanRecordCache(oldRecord.getLessonId(), oldRecord.getSectionId());
                }
            }
        }
        // 处理课表
        handleLearnLesson(command,finished);
    }

}
