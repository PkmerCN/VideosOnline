package org.hzz.core.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T> {

    @Schema(description = "总记录数")
    private Integer total;

    @Schema(description = "总页数")
    private Integer totalPages;

    @Schema(description = "当前页")
    private Integer currentPageNo;

    @Schema(description = "当前页数据")
    private List<T> list;
}
