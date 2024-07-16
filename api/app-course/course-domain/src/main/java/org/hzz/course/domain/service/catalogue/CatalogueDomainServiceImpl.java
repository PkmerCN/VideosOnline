package org.hzz.course.domain.service.catalogue;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.course.domain.entity.CourseCatalogueEntity;
import org.hzz.course.domain.repository.catalogue.CatalogueRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Service
public class CatalogueDomainServiceImpl
        extends BaseDomainService<CatalogueRepository>
        implements CatalogueDomainService{
    /**
     * {@inheritDoc}
     */
    @Override
    public List<CourseCatalogueEntity> getEntities(Set<Long> ids) {
        List<CourseCatalogueEntity> courseCatalogueEntities = repository.selectEntities(ids);
        if(CollUtil.isEmpty(courseCatalogueEntities)){
            logger.info("没有数据");
            return Collections.emptyList();
        }
        logger.info("查询到 {} 条数据",courseCatalogueEntities.size());
        return courseCatalogueEntities;
    }
}
