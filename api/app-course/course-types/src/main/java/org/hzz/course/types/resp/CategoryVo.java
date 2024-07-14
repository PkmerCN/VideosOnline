package org.hzz.course.types.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hzz.course.types.enums.CategoryLevel;
import org.hzz.fastjson2.enums.BaseEnumWriter;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@Data
@Schema(description = "所有课程分类数据")
public class CategoryVo {
    @Schema(description = "课程分类id")
    private Long id;

    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "父分类id，一级分类父id为0")
    private Long parentId;

    @Schema(description = "分类级别，1,2,3：代表一级分类，二级分类，三级分类")
    @JSONField(serializeUsing = BaseEnumWriter.class)
    private CategoryLevel level;

    @Schema(description = "子分类")
    List<CategoryVo> children;
}
