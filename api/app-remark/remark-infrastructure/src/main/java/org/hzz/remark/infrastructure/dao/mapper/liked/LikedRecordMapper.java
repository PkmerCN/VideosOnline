package org.hzz.remark.infrastructure.dao.mapper.liked;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.remark.infrastructure.dao.model.liked.LikedRecord;
import org.hzz.remark.infrastructure.dao.model.liked.LikedRecordExample;

import java.util.List;

@Mapper
public interface LikedRecordMapper {
    long countByExample(LikedRecordExample example);

    int deleteByExample(LikedRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LikedRecord row);

    int insertSelective(LikedRecord row);

    List<LikedRecord> selectByExample(LikedRecordExample example);

    LikedRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") LikedRecord row, @Param("example") LikedRecordExample example);

    int updateByExample(@Param("row") LikedRecord row, @Param("example") LikedRecordExample example);

    int updateByPrimaryKeySelective(LikedRecord row);

    int updateByPrimaryKey(LikedRecord row);
}