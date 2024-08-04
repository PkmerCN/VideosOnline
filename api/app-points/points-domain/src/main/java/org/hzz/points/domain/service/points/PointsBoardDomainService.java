package org.hzz.points.domain.service.points;

import org.hzz.core.page.query.PageQuery;
import org.hzz.ddd.core.domain.shared.service.DomainService;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.repository.PointsBoardCurrentRepository;
import org.hzz.points.types.req.PointsBoardQuery;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 积分排行榜领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
public interface PointsBoardDomainService extends DomainService {

    /**
     * 查询当前积分排行榜
     * @param pageQuery 积分排行榜分页查询
     * @return 排行榜数据
     */
    List<PointsBoardEntity> queryCurrentPointsBoardList(PointsBoardQuery pageQuery);

    /**
     * 分页查询上赛季积分排行榜
     * @param pageQuery 分页
     * @return 排行榜数据
     */
     List<PointsBoardEntity> queryPrePointsBoardList(PageQuery pageQuery);

    /**
     * 查询历史积分排行榜
     */
    void queryHistoryPointsBoardList();

    void queryUserHistoryPointsBoard(Long userId);
    /**
     * 查询用户当前积分排名
     */
    PointsBoardEntity queryUserCurrentPointsBoard(Long userId);

}
