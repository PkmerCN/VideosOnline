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


    /**
     * 统计连续为1的bit
     * @param userId 用户id
     * @param offset 起始位
     * @param len 长度
     * @return 连续为1的bit位
     */
    int count(Long userId, int offset,int len);

    /**
     * 查询用户的签到记录
     * 比如一个月，1号为0,到10号，10天的签到记录，offset = 0,len = 10
     * @param userId 用户id
     * @param offset 起始位置
     * @param len 长度
     * @return 数组，值为0和1,0代表未签到，1代表签到
     */
    int[] querySignRecords(Long userId,int offset,int len);


}
