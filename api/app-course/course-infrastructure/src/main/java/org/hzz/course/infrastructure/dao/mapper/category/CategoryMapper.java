package org.hzz.course.infrastructure.dao.mapper.category;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.course.infrastructure.dao.model.category.Category;
import org.hzz.course.infrastructure.dao.model.category.CategoryExample;

@Mapper
public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Category row);

    int insertSelective(Category row);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Category row, @Param("example") CategoryExample example);

    int updateByExample(@Param("row") Category row, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category row);

    int updateByPrimaryKey(Category row);
}