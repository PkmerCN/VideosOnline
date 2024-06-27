package org.hzz.core.page.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页请求
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Data
@Schema(description = "分页请求")
public class PageQuery {
    private static final Integer DEFAULT_PAGE_NO = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 20;

    @Schema(description = "页码",example = "1")
    @Min(value = 1,message = "页码不能小于1")
    private Integer pageNo = DEFAULT_PAGE_NO;

    @Schema(description = "每页大小",example = "20")
    @Min(value = 1,message = "每页查询数量不能小于1")
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    @Schema(description = "排序方式",example = "id")
    private String sortBy;

    @Schema(description = "是否升序",example = "true")
    private Boolean isAsc = true;

    @Schema(description = "排序字段和顺序")
    private List<SortOrder> sortOrders = new ArrayList<>();

    @Schema(description = "过滤条件")
    private List<FilterCondition> filters = new ArrayList<>();

}
