package org.hzz.core.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T> {

    @Schema(description = "总记录数")
    protected Integer total;

    @Schema(description = "总页数")
    protected Integer totalPages;

    @Schema(description = "当前页")
    protected Integer currentPageNo;

    @Schema(description = "当前页数据")
    protected List<T> list;
}
