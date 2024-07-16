package org.hzz.course.api.catalogue.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.course.api.catalogue.TestCatalogueApi;
import org.hzz.course.domain.entity.CourseCatalogueEntity;
import org.hzz.course.domain.service.catalogue.CatalogueDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@RestController
public class TestCatalogueController
            extends BaseController
    implements TestCatalogueApi
{

    // 为了方便测试我直接引入了领域服务
    @Setter(onMethod_ = @Autowired)
    private CatalogueDomainService domainService;

    @Override
    public Result<Object> getCatalogues(List<Long> ids) {
        logger.info("测试章节数据");
        List<CourseCatalogueEntity> entities = domainService.getEntities(new HashSet<>(ids));
        return success(entities);
    }
}
