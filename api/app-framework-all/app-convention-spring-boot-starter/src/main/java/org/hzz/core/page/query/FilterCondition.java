package org.hzz.core.page.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "筛选条件")
public class FilterCondition {
    @Schema(description = "字段名", example = "user_id")
    private String field;

    @Schema(description = "操作符", example = "=")
    private String operator;

    @Schema(description = "值", example = "3")
    private Object value;

    @Override
    public String toString() {
        return "FilterCondition{ " +
                field + " " + operator + " " + value +
                " }";
    }


    public static interface Operation{
        String Equal = "=";
        String GreaterOrEqual = ">=";

        String LessOrEqual = "<=";


    }

}
