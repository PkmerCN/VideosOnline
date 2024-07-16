package org.hzz.course.infrastructure.repository.mybatis.catalogue;

import org.hzz.common.tree.BaseConverter;
import org.hzz.core.enums.delete.Deleted;
import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.course.domain.entity.CourseCatalogueEntity;
import org.hzz.course.domain.repository.catalogue.CatalogueRepository;
import org.hzz.course.infrastructure.dao.mapper.catalogue.CourseCatalogueMapper;
import org.hzz.course.infrastructure.dao.model.catalogue.CourseCatalogue;
import org.hzz.course.infrastructure.dao.model.catalogue.CourseCatalogueExample;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Repository
public class CatalogueRepositoryImpl
        extends BaseRepository<CourseCatalogueMapper>
        implements CatalogueRepository {

    @Override
    public List<CourseCatalogueEntity> selectEntities(Set<Long> ids) {
        CourseCatalogueExample example = new CourseCatalogueExample();
        example.createCriteria().andIdIn(new ArrayList<>(ids));

        List<CourseCatalogue> courseCatalogues = mapper.selectByExample(example);

        return CourseCatalogueConvert.INSTANCE.covertToList(courseCatalogues);
    }

    @Mapper
    interface CourseCatalogueConvert extends BaseConverter<CourseCatalogueEntity,CourseCatalogue>{
        CourseCatalogueConvert INSTANCE = Mappers.getMapper(CourseCatalogueConvert.class);
    }
}
