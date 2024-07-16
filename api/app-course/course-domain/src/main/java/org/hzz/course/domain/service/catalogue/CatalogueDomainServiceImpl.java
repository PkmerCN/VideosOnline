package org.hzz.course.domain.service.catalogue;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.course.domain.entity.CourseCatalogueEntity;
import org.hzz.course.domain.repository.catalogue.CatalogueRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Long, CourseCatalogueEntity> getMapEntities(Set<Long> ids) {
        return getEntities(ids).stream().collect(Collectors.toMap(
                CourseCatalogueEntity::getId,
                e -> e
        ));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Long, String> getMapIdAndName(Set<Long> ids) {
        return getMapEntities(ids).entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().getName()
        ));
    }
}
