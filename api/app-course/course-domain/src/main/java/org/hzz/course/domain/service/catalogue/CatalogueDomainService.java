package org.hzz.course.domain.service.catalogue;

import org.hzz.course.domain.entity.CourseCatalogueEntity;

import java.util.List;
import java.util.Set;
import java.util.Map;

/**
 * 章节领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public interface CatalogueDomainService{

    /**
     * 获取章节数据
     * @param ids id 列表
     * @return 根据id获取章节 List
     */
    List<CourseCatalogueEntity> getEntities(Set<Long> ids);

    /**
     * 获取章节数据
     * @param ids id 列表
     * @return Map key -> id value -> {@link CourseCatalogueEntity}
     */
    Map<Long,CourseCatalogueEntity> getMapEntities(Set<Long> ids);

    /**
     * 获取章节简单数据，只包含id和name
     * @param ids id 列表
     * @return Map key -> id value -> 章节名字
     */
    Map<Long,String> getMapIdAndName(Set<Long> ids);
}
