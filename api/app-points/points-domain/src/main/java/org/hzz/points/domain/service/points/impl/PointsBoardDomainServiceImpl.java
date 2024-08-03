package org.hzz.points.domain.service.points.impl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.repository.PointsBoardCurrentRepository;
import org.hzz.points.domain.repository.PointsBoardHistoryRepository;
import org.hzz.points.domain.service.points.PointsBoardDomainService;
import org.hzz.points.types.req.PointsBoardQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
@Service
@Slf4j
public class PointsBoardDomainServiceImpl  implements PointsBoardDomainService {

    @Setter(onMethod_ = @Autowired)
    private PointsBoardCurrentRepository currentRepository;
//    @Setter(onMethod_ = @Autowired)
//    private PointsBoardHistoryRepository historyRepository;


    /**
     * {@inheritDoc}
     * @param pageQuery 积分排行榜分页查询
     * @return 排行榜
     */
    @Override
    public List<PointsBoardEntity> queryCurrentPointsBoardList(PointsBoardQuery pageQuery) {
        log.info("查询当前赛季排行榜信息");
        return currentRepository.queryCurrentPointsBoardList(pageQuery);
    }

    @Override
    public void queryHistoryPointsBoardList() {

    }

    @Override
    public void queryUserHistoryPointsBoard(Long userId) {


    }

    /**
     * {@inheritDoc}
     * @param userId 用户id
     * @return 用户本赛季的积分数据
     */
    @Override
    public PointsBoardEntity queryUserCurrentPointsBoard(Long userId) {
        log.info("查询用户当前赛季排行榜信息");
        return currentRepository.queryUserCurrentPointsBoard(userId);
    }
}
