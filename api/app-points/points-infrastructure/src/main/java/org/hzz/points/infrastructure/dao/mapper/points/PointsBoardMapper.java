package org.hzz.points.infrastructure.dao.mapper.points;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.points.infrastructure.dao.model.points.PointsBoard;
import org.hzz.points.infrastructure.dao.model.points.PointsBoardExample;

import java.util.List;

@Mapper
public interface PointsBoardMapper {
    long countByExample(PointsBoardExample example);

    int deleteByExample(PointsBoardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PointsBoard row);

    int insertSelective(PointsBoard row);

    List<PointsBoard> selectByExample(PointsBoardExample example);

    PointsBoard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") PointsBoard row, @Param("example") PointsBoardExample example);

    int updateByExample(@Param("row") PointsBoard row, @Param("example") PointsBoardExample example);

    int updateByPrimaryKeySelective(PointsBoard row);

    int updateByPrimaryKey(PointsBoard row);
}