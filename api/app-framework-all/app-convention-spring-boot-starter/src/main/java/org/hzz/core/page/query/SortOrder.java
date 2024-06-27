package org.hzz.core.page.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Data
@Schema(description = "排序字段和顺序")
public class SortOrder{
    @Schema(description = "排序方式",example = "id")
    private String field;

    @Schema(description = "是否升序",example = "true")
    private Boolean isAsc = true;
}
