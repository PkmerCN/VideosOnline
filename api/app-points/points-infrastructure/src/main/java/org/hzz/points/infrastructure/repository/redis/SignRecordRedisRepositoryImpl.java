package org.hzz.points.infrastructure.repository.redis;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.collection.CollUtil;
import org.hzz.common.date.DateUtil;
import org.hzz.points.domain.repository.SignRecordRedisRepository;
import org.hzz.points.types.constants.RedisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * string数据结构
 * 比如sign::uid::1::202407 -> bitmap
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@Repository
@Slf4j
public class SignRecordRedisRepositoryImpl implements SignRecordRedisRepository {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object, Object> redisTemplate;


    /**
     * 添加用户签到记录
     *
     * @param userId 用户ID
     * @return 如果不存在插入一条记录 返回false ; 如果已经存在再出入一条同样的记录返回true
     */
    @Override
    public Boolean addSignRecord(Long userId) {
        // 操作redis setbit key
        LocalDateTime now = LocalDateTime.now();
        int day = now.getDayOfMonth() - 1;
        String key = getSignKey(userId, now);
        log.info("添加用户{},第{}天签到记录", key, day);
        /**
         * 已经存在这条记录了会返回什么?:
         * 如果不存在插入一条记录 返回false
         * 如果已经存在再出入一条同样的记录返回true
         */
        return redisTemplate.opsForValue().setBit(key, day, true);
    }

    /**
     * 统计连续为1的bit
     *
     * @param userId 用户id
     * @param offset 起始位
     * @param len    长度
     * @return 连续为1的bit位
     */
    @Override
    public int count(Long userId, int offset, int len) {
        int bitValue = getUserSignBitValue(userId, offset, len);
        int count = 0;
        // 位运算
        while((bitValue & 1) == 1){
            count++;
            bitValue >>>= 1;
        }
        return count;
    }

    @Override
    public int[] querySignRecords(Long userId, int offset, int len) {
        int[] signRecords = new int[len];
        int bitValue = getUserSignBitValue(userId, offset, len);

        for(int i = len - 1;i>=0;i-- ){
            signRecords[i] = bitValue & 1;
            bitValue >>>= 1;
        }
        return signRecords;
    }

    /**
     * 获取redis 签到key
     * 比如sign::uid::1::202407
     *
     * @param userId 用户id
     * @param now    时间
     * @return key
     */
    private String getSignKey(Long userId, LocalDateTime now) {
        return StrUtil.format(RedisConstants.SIGN_RECORD_TEMPLATE,
                userId,
                now.format(DateUtil.getMonthFormatCompact()));
    }


    /**
     * 获取用户对应的签到记录bitValue
     * sign::uid::1::202407 -> bitValue
     * @param userId 用户id
     * @param offset 起始偏移量
     * @param len 长度
     * @return bitvalue
     */
    private int getUserSignBitValue(Long userId, int offset, int len){
        List<Long> bitFieldResult = redisTemplate.opsForValue().bitField(
                getSignKey(userId, LocalDateTime.now()),
                BitFieldSubCommands.create()
                        .get(BitFieldSubCommands.BitFieldType.unsigned(len)).valueAt(offset));

        if(CollUtil.isEmpty(bitFieldResult)){
            return 0;
        }

        int bitValue =  bitFieldResult.get(0).intValue();
        String binaryRepresentation = String.format("%8s", Long.toBinaryString(bitValue)).trim();
        log.info("获取到bit value = {}",binaryRepresentation);
        return bitValue;
    }
}
