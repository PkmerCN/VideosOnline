package org.hzz.course.types.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hzz.course.types.enums.catagory.CategoryLevel;
import org.hzz.fastjson2.enums.BaseEnumWriter;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@Data
@Schema(description = "所有课程分类数据")
public class CategoryTreeVo {
    @Schema(description = "课程分类id")
    @JSONField(ordinal = 0)
    private Long id;

    @Schema(description = "分类名称")
    @JSONField(ordinal = 1)
    private String name;

    @Schema(description = "父分类id，一级分类父id为0")
    @JSONField(ordinal = 2)
    private Long parentId;

    @Schema(description = "分类级别，1,2,3：代表一级分类，二级分类，三级分类")
    @JSONField(serializeUsing = BaseEnumWriter.class,ordinal = 3)
    private CategoryLevel level;

    @Schema(description = "子分类")
    @JSONField(ordinal = 4)
    List<CategoryTreeVo> children;
}
