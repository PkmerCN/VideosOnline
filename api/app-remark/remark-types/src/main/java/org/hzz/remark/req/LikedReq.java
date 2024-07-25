package org.hzz.remark.req;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hzz.fastjson2.enums.BaseEnumReader;
import org.hzz.remark.types.BizType;

/**
 * 点赞请求
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Data
@Schema(description = "点赞请求")
public class LikedReq {
    @Schema(description = "业务id")
    @NotNull
    Long bizId;

    @Schema(description = "业务类型",example = "QA")
    @NotNull
    @JSONField(deserializeUsing = BaseEnumReader.class)
    BizType bizType;

    @Schema(description = "点赞（true）或者取消点赞（false）",example = "true")
    Boolean liked;
}
