package org.hzz.points.domain.service.points;

import org.hzz.ddd.core.domain.shared.service.DomainService;

/**
 * 积分排行榜领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
public interface PointsBoardDomainService extends DomainService {

    /**
     * 查询当前积分排行榜
     */
    void queryCurrentPointsBoardList();

    /**
     * 查询历史积分排行榜
     */
    void queryHistoryPointsBoardList();

    void queryUserHistoryPointsBoard(Long userId);
    /**
     * 查询用户当前积分排名
     */
    void queryUserCurrentPointsBoard(Long userId);

}
