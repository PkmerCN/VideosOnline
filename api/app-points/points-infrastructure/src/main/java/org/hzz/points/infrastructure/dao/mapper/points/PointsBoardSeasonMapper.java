package org.hzz.points.infrastructure.dao.mapper.points;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.points.infrastructure.dao.model.points.PointsBoardSeason;
import org.hzz.points.infrastructure.dao.model.points.PointsBoardSeasonExample;

import java.util.List;
@Mapper
public interface PointsBoardSeasonMapper {
    long countByExample(PointsBoardSeasonExample example);

    int deleteByExample(PointsBoardSeasonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PointsBoardSeason row);

    int insertSelective(PointsBoardSeason row);

    List<PointsBoardSeason> selectByExample(PointsBoardSeasonExample example);

    PointsBoardSeason selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") PointsBoardSeason row, @Param("example") PointsBoardSeasonExample example);

    int updateByExample(@Param("row") PointsBoardSeason row, @Param("example") PointsBoardSeasonExample example);

    int updateByPrimaryKeySelective(PointsBoardSeason row);

    int updateByPrimaryKey(PointsBoardSeason row);
}