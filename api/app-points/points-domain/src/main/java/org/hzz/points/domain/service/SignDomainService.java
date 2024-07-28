package org.hzz.points.domain.service;

import org.hzz.ddd.core.domain.shared.service.DomainService;
import org.hzz.points.types.resp.SignResultVo;

/**
 * 签到领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
public interface SignDomainService extends DomainService {

    /**
     * 添加签到记录
     * @param userId 签到用户id
     * @return 签到结果
     */
    SignResultVo addSignRecord(Long userId);

    /**
     * 计算用户本月连续签到的天数，以最新为准
     * @param userId 用户id
     * @param endDay 统计到达的天数，也就是一个月的几号
     * @return 本月最新连续签到天数
     */
    int countSignDays(Long userId,int endDay);

    /**
     * 以今天开始往之前的天数开始计算用户本月连续签到的天数
     * @param userId 用户id
     * @return 本月最新连续签到天数
     */
    int countSignDaysForToday(Long userId);
}
