package org.hzz.learning.application.task.impl;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hzz.cache.core.RedisCache;
import org.hzz.learning.application.task.DelayTask;
import org.hzz.learning.application.task.DelayTaskHandler;
import org.hzz.learning.domain.aggregate.LearnLessonAggregate;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.domain.service.LearnLessonDomainService;
import org.hzz.learning.domain.service.LearnLessonRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/9
 */
@Component
@Slf4j
public class RecordDelayTaskHandler implements DelayTaskHandler {

    @Setter(onMethod_ = @Autowired)
    private LearnLessonRecordDomainService learnLessonRecordDomainService;
    @Setter(onMethod_ = @Autowired)
    private LearnLessonDomainService learnLessonDomainService;

    /**
     * 防止事务失效
     */
    @Autowired
    @Lazy
    private RecordDelayTaskHandler self;

    private final RedisCache redisCache;
    private final DelayQueue<DelayTask<RecordTaskData>> queue;
    private final static String RECORD_KEY_TEMPLATE = "learning:record:{}";
    private volatile boolean start;

    private final Executor executor = Executors.newFixedThreadPool(10);
    public RecordDelayTaskHandler(RedisCache redisCache){
        this.redisCache = redisCache;
        queue = new DelayQueue<>();
    }


    @PostConstruct
    public void init(){
        start = true;
        log.info("启动record延迟任务 start = {}",start);
        CompletableFuture.runAsync(this::handleTask);
    }

    @PreDestroy
    public void destroy(){
        start = false;
        log.info("关闭record延迟任务 start = {}",start);
    }

    private void handleTask(){
        while(start){
            try {
                final DelayTask<RecordTaskData> task = queue.take();
                log.info("获取到任务");
                executor.execute(()->{
                    RecordTaskData taskData = task.getData();
                    RecordCacheData cacheData = readRedisCache(taskData.getLessonId(), taskData.getSectionId());

                    if(cacheData != null &&
                            taskData.getMoment().equals(cacheData.getMoment())){
                        // 说明用户没有连续在看需要保存记录
                        log.info("存储记录");
                        save(taskData);
                    }

                });


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save(RecordTaskData taskData){
        Long lessonId = taskData.getLessonId();
        Long sectionId = taskData.getSectionId();
        LearnRecordEntity learnRecord = learnLessonRecordDomainService.findLearnRecord(lessonId, sectionId);
        // 更新学习的时长
        learnRecord.setMoment(taskData.getMoment());

        LearningLessonEntity learningLesson = learnLessonDomainService.getLearnLessonAggregate(lessonId).getLearningLesson();
        // 更新最近学习时间和小节
        learningLesson.setLatestLearnTime(LocalDateTime.now());
        learningLesson.setLatestSectionId(sectionId);
        self.doSave(learningLesson,learnRecord);
    }

    @Transactional
    public void doSave(LearningLessonEntity learningLesson,LearnRecordEntity learnRecord){
        learnLessonRecordDomainService.updateRecord(learnRecord);
        learnLessonDomainService.updateLessonSelectiveById(learningLesson);
    }

    /**
     * 添加学习记录到缓存
     * @param recordEntity 学习记录
     */
    public void addLearningRecordTask(LearnRecordEntity recordEntity){
        // 写入缓存
        writeRedisCache(recordEntity);
        // 添加延迟任务
        addDelayTask(recordEntity);
    }

    /**
     * 删除缓存
     * @param lessonId 课程id
     * @param sectionId 小节id
     */
    public void cleanRecordCache(Long lessonId,Long sectionId){
        String key = buildKey(lessonId);
        redisCache.delMapValue(key,sectionId.toString());
    }

    /**
     * 添加延迟任务
     */
    private void addDelayTask(LearnRecordEntity recordEntity){
        RecordTaskData data = RecordTaskData.createFrom(recordEntity);
        DelayTask<RecordTaskData> task = new DelayTask<>(data, Duration.ofSeconds(20));
        queue.add(task);
    }

    /**
     * 写入Redis缓存
     */
    private void writeRedisCache(LearnRecordEntity recordEntity){
        RecordCacheData recordCacheData = RecordCacheData.createFrom(recordEntity);
        String key = buildKey(recordEntity.getLessonId());
        redisCache.setMapValue(key,recordEntity.getSectionId().toString(),recordCacheData);
        // 设置缓存时间
        redisCache.expire(key,Duration.ofMinutes(2));
    }

    /**
     * 获取record缓存数据
     * @param lessonId 课程id
     * @param sectionId 小节id
     * @return RecordCacheData
     */
    private RecordCacheData readRedisCache(Long lessonId,Long sectionId){
        String key = buildKey(lessonId);
        RecordCacheData data = redisCache.getMapValue(key, sectionId.toString(), RecordCacheData.class);
        if(data != null){
            log.info("成功从redis里面读取到record = [ moment  = {} ]",data.getMoment());
        }
        return data;
    }

    /**
     * 构建redis key
     * @param lessonId 课程id
     * @return key
     */
    private String buildKey(Long lessonId){
        return StrUtil.format(RECORD_KEY_TEMPLATE, lessonId);
    }


    /**
     * redis缓存数据
     */
    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    public static class RecordCacheData{
        private Long id;
        private Integer moment;
        private Boolean finished;

       static RecordCacheData createFrom(LearnRecordEntity recordEntity){
           RecordCacheData data = new RecordCacheData();
           data.setId(recordEntity.getId())
                   .setMoment(recordEntity.getMoment())
                   .setFinished(recordEntity.getFinished());
           return data;
       }
    }

    /**
     * 延迟任务数据
     */
    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    public static class RecordTaskData{
        private Long lessonId;
        private Long sectionId;
        private Integer moment;

        static RecordTaskData createFrom(LearnRecordEntity recordEntity){
            RecordTaskData recordTaskData = new RecordTaskData();
            recordTaskData.setMoment(recordEntity.getMoment())
                    .setSectionId(recordEntity.getSectionId())
                    .setLessonId(recordEntity.getLessonId());
            return recordTaskData;
        }
    }
}
