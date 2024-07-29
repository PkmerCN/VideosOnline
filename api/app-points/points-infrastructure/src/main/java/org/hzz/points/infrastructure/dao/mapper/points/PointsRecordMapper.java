package org.hzz.points.infrastructure.dao.mapper.points;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.points.infrastructure.dao.model.points.PointsRecord;
import org.hzz.points.infrastructure.dao.model.points.PointsRecordExample;

import java.util.List;

@Mapper
public interface PointsRecordMapper {
    long countByExample(PointsRecordExample example);

    int deleteByExample(PointsRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PointsRecord row);

    int insertSelective(PointsRecord row);

    List<PointsRecord> selectByExample(PointsRecordExample example);

    PointsRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") PointsRecord row, @Param("example") PointsRecordExample example);

    int updateByExample(@Param("row") PointsRecord row, @Param("example") PointsRecordExample example);

    int updateByPrimaryKeySelective(PointsRecord row);

    int updateByPrimaryKey(PointsRecord row);
}