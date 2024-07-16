package org.hzz.course.domain.service.catalogue;

import org.hzz.course.domain.entity.CourseCatalogueEntity;

import java.util.List;
import java.util.Set;

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
}
