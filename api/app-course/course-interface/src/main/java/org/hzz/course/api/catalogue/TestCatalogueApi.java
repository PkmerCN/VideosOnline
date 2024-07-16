package org.hzz.course.api.catalogue;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hzz.core.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Tag(name="章节目录测试")
@RequestMapping("/test/catalogue")
public interface TestCatalogueApi {

    @Operation(description = "根据id获取数据,如?ids=2,3,4,5,6")
    @GetMapping
    Result<Object> getCatalogues(@RequestParam("ids")List<Long> ids);
}
