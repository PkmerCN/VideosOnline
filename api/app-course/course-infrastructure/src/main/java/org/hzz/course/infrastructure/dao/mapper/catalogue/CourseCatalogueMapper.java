package org.hzz.course.infrastructure.dao.mapper.catalogue;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.course.infrastructure.dao.model.catalogue.CourseCatalogue;
import org.hzz.course.infrastructure.dao.model.catalogue.CourseCatalogueExample;

import java.util.List;

@Mapper
public interface CourseCatalogueMapper {
    long countByExample(CourseCatalogueExample example);

    int deleteByExample(CourseCatalogueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseCatalogue row);

    int insertSelective(CourseCatalogue row);

    List<CourseCatalogue> selectByExample(CourseCatalogueExample example);

    CourseCatalogue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CourseCatalogue row, @Param("example") CourseCatalogueExample example);

    int updateByExample(@Param("row") CourseCatalogue row, @Param("example") CourseCatalogueExample example);

    int updateByPrimaryKeySelective(CourseCatalogue row);

    int updateByPrimaryKey(CourseCatalogue row);
}