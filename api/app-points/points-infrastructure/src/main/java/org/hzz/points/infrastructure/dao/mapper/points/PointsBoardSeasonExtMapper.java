package org.hzz.points.infrastructure.dao.mapper.points;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Mapper
public interface PointsBoardSeasonExtMapper {

    void createPointsBoardSeasonTable(@Param("tableName") String tableName);
}
