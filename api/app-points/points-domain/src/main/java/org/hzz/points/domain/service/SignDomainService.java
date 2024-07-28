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
}
