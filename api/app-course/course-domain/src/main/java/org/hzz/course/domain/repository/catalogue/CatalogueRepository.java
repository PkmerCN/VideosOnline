package org.hzz.course.domain.repository.catalogue;

import org.hzz.course.domain.entity.CourseCatalogueEntity;

import java.util.List;
import java.util.Set;

/**
 * 章节Repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public interface CatalogueRepository {

    /**
     * 获取章节数据
     * @param ids id
     * @return 根据id获取章节 List
     */
    List<CourseCatalogueEntity> selectEntities(Set<Long> ids);


}
