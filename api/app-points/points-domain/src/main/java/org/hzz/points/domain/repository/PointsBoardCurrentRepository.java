package org.hzz.points.domain.repository;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.date.DateUtil;
import org.hzz.core.page.query.PageQuery;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.types.constants.RedisConstants;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 积分排行榜redis repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
public interface PointsBoardCurrentRepository {

    /**
     * 构建key
     * @return 例如boards::202408
     */
    default String buildKey(LocalDateTime dateTime) {
        return StrUtil.format(RedisConstants.BOARDS_TEMPLATE,
                dateTime.format(DateUtil.getMonthFormatCompact()));
    }


    /**
     * 查询用户当前积分排名
     */
    PointsBoardEntity queryUserCurrentPointsBoard(Long userId);

    /**
     * 分页查询积分排行榜
     * @param key {@link PointsBoardCurrentRepository#buildKey(LocalDateTime)}
     * @param pageQuery 分页
     * @return 排行榜数据
     */
     List<PointsBoardEntity> queryPointsBoardListByKey(String key,PageQuery pageQuery);


    /**
     * 增加用户当前赛季积分
     */
    void incrUserPoints(PointsRecordEntity entity);

    /**
     * 积分排行榜
     * @param key key
     */
    void clearPointsBoardList(String key);
}
