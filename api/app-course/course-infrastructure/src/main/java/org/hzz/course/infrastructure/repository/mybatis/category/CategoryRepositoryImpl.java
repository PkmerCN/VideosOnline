package org.hzz.course.infrastructure.repository.mybatis.category;

import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.domain.repository.category.CategoryRepository;
import org.hzz.course.infrastructure.dao.mapper.category.CategoryMapper;
import org.hzz.course.infrastructure.dao.model.category.Category;
import org.hzz.course.infrastructure.dao.model.category.CategoryExample;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Repository
public class CategoryRepositoryImpl
        extends BaseRepository<CategoryMapper>
        implements CategoryRepository {
    @Override
    public List<CategoryEntity> selectByIds(Set<Long> ids) {

        CategoryExample example = new CategoryExample();
        example.createCriteria().andIdIn(new ArrayList<>(ids));

        List<Category> categories = mapper.selectByExample(example);
        return Converter.INSTANCE.toEntities(categories);
    }


    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
        List<CategoryEntity> toEntities(List<Category> records);
        CategoryEntity toEntity(Category record);
    }
}
