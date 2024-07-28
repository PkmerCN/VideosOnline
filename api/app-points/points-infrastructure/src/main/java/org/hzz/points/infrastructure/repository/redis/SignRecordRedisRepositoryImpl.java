package org.hzz.points.infrastructure.repository.redis;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.date.DateUtil;
import org.hzz.points.domain.repository.SignRecordRedisRepository;
import org.hzz.points.types.constants.RedisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * string数据结构
 * 比如sign::uid::1::202407 -> bitmap
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@Repository
@Slf4j
public class SignRecordRedisRepositoryImpl implements SignRecordRedisRepository {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 添加用户签到记录
     * @param userId 用户ID
     * @return 如果不存在插入一条记录 返回false ; 如果已经存在再出入一条同样的记录返回true
     */
    @Override
    public Boolean addSignRecord(Long userId) {
        // 操作redis setbit key
        LocalDateTime now = LocalDateTime.now();
        // sign::uid::1::202407
        String key = StrUtil.format(RedisConstants.SIGN_RECORD_TEMPLATE,
                userId,
                now.format(DateUtil.getMonthFormatCompact()));
        int day = now.getDayOfMonth() - 1;
        log.info("添加用户{},第{}天签到记录",key,day);
        /**
         * 已经存在这条记录了会返回什么?:
         * 如果不存在插入一条记录 返回false
         * 如果已经存在再出入一条同样的记录返回true
         */
        return redisTemplate.opsForValue().setBit(key, day, true);
    }
}
