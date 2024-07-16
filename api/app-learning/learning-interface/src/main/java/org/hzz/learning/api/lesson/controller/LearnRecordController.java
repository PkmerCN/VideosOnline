package org.hzz.learning.api.lesson.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.controller.BaseController;
import org.hzz.core.exception.arg.AppArgumentNotValidException;
import org.hzz.core.result.Result;
import org.hzz.learning.api.lesson.LearnRecordApi;
import org.hzz.learning.api.req.LearningRecordFormRequest;
import org.hzz.learning.application.service.AppLearningLessonService;
import org.hzz.learning.application.command.lesson.LearnLessonRecordCommand;
import org.hzz.learning.application.command.lesson.LearnRecordCommitCommand;
import org.hzz.learning.application.resp.LearnLessonRecordDto;
import org.hzz.learning.domain.enums.SectionType;
import org.hzz.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Set;


/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@RestController
public class LearnRecordController extends BaseController implements LearnRecordApi {
    @Setter(onMethod_ = @Autowired)
    private AppLearningLessonService appLearningLessonService;
    @Setter(onMethod_ = @Autowired)
    private Validator validator;

    @Override
    public Result<LearnLessonRecordDto> queryLearningRecordByCourseId(Long courseId) {
        logger.info("查询用户课程 {id = {}} 小节信息",courseId);
        LearnLessonRecordCommand command = LearnLessonRecordCommand.commandOf(
                AppContextHolder.userContextHolder.getUser().getId(),
                courseId);
        LearnLessonRecordDto learnLessonRecordDto = appLearningLessonService.queryLearningRecord(command);
        return success(learnLessonRecordDto);
    }

    @Override
    public Result<Object> commitLearnRecord(LearningRecordFormRequest request) {
        // 手动进行分组校验
        validLearningRecordFormRequest(request);
        logger.info("提交学习记录 lessonID = {}",request.getLessonId());

        LearnRecordCommitCommand command = new LearnRecordCommitCommand()
                .setUserId(AppContextHolder.userContextHolder.getUser().getId())
                .setLessonId(request.getLessonId())
                .setSectionId(request.getSectionId())
                .setCommitTime(request.getCommitTime())
                .setDuration(request.getDuration())
                .setMoment(request.getMoment())
                .setSectionType(request.getSectionType());

        appLearningLessonService.commitLearnLesssonRecord(command);
        return success(null);
    }

    /**
     * 基于视频记录还是考试记录进行分组手动校验
     */
    private void validLearningRecordFormRequest(LearningRecordFormRequest request){
        Set<ConstraintViolation<LearningRecordFormRequest>> sets = null;
        if(request.getSectionType() == SectionType.EXAM){
            sets = validator.validate(request, LearningRecordFormRequest.ExamGroup.class);
        }else if(request.getSectionType() == SectionType.VIDEO){
            sets = validator.validate(request,LearningRecordFormRequest.VideoGroup.class);
        }else{
            // 兜底校验,因为sectionType可能为null
            sets = validator.validate(request,
                    LearningRecordFormRequest.VideoGroup.class,
                    LearningRecordFormRequest.ExamGroup.class);
        }

        if(CollUtil.isNotEmpty(sets)){
            // http://localhost:8080/learning-records
            String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
            // /learning-records
            String path = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
            logger.info("请求路径: {} 参数校验不合法",path);
            throw new AppArgumentNotValidException(sets);
        }
    }
}
