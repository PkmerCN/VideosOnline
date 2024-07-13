package org.hzz.course.domain.service.category.impl;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.domain.repository.category.CategoryRepository;
import org.hzz.course.domain.service.category.CategoryDomainService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Service
public class CategoryDomainServiceImpl
        extends BaseDomainService<CategoryRepository>
        implements CategoryDomainService
{
    @Override
    public List<CategoryEntity> getCategoryEntities(Set<Long> ids) {
        if(CollUtil.isEmpty(ids)){
           return Collections.emptyList();
        }

        List<CategoryEntity> categoryEntities = repository.selectByIds(ids);
        if(CollUtil.isNotEmpty(categoryEntities)){
            logger.info("查询到{}个分类",categoryEntities.size());
        }
        return categoryEntities;
    }
}
