package org.hzz.remark.application.task;

import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.PostConstruct;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.remark.domain.service.LikedRecordDomainService;
import org.hzz.remark.domain.service.impl.LikedRecordRedisDomainServiceImpl;
import org.hzz.remark.types.BizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务，处理redis中的likes点赞总数
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/27
 */
@Slf4j
@Component
public class LikeTimesCheckTask {

    @Setter(onMethod_ = {
            @Autowired,
            @Qualifier("likedRecordRedisDomainService")
    })
    private LikedRecordRedisDomainServiceImpl domainService;

    private List<String> bizTypes = new ArrayList<>();
    private Long count;

    @PostConstruct
    public void init(){
        bizTypes.addAll(getBizType());
        count = 30L;
    }

//    @Scheduled(fixedDelay = 3,timeUnit = TimeUnit.SECONDS)
    @XxlJob("handleLikesToDB")
    public void test(){
        log.info("准备处理业务的点赞总数");
        for(String bizType: bizTypes){
            domainService.readLikedTimesAndSendMsg(bizType,count);
        }
    }

    /**
     * 获取当前业务类型
     */
    public List<String> getBizType(){
        List<String> results = new ArrayList<>();
        for(BizType bizType: BizType.values()){
            String value = bizType.getValue();
            results.add(value);
        }
        return results;
    }
}
