package org.hzz.points.domain.repository;

/**
 * string数据结构
 * 比如sign::uid::1::202407 -> bitmap
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
public interface SignRecordRedisRepository {

    /**
     * 添加用户签到记录
     * @param userId 用户ID
     * @return 如果不存在插入一条记录 返回false ; 如果已经存在再插入一条同样的记录返回true
     */
    Boolean addSignRecord(Long userId);
}
