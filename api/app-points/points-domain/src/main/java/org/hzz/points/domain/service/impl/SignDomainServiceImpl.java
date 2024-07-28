package org.hzz.points.domain.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.date.DateUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.service.SignDomainService;
import org.hzz.points.types.constants.RedisConstants;
import org.hzz.points.types.resp.SignResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@Service
@Slf4j
public class SignDomainServiceImpl implements SignDomainService {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object,Object> redisTemplate;


    /**
     * {@inheritDoc}
     */
    @Override
    public SignResultVo addSignRecord(Long userId) {
        // todo 抽象redis repository

        // 操作redis setbit key
        LocalDateTime now = LocalDateTime.now();
        String key = StrUtil.format(RedisConstants.SIGN_RECORD_TEMPLATE,
                userId,
                now.format(DateUtil.getMonthFormatCompact()));
        int day = now.getDayOfMonth() - 1;
        log.info("添加用户{},第{}天签到记录",key,day);
        // todo 已经存在这条记录了会返回什么
        Boolean result = redisTemplate.opsForValue().setBit(key, day, true);
//        if(Boolean.TRUE.equals(result))
        System.out.println(result);


        return null;
    }
}
