package org.hzz.learning.types.req.reply;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hzz.core.page.query.PageQuery;

/**
 * 分页查询回答或者评论
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReplyPage extends PageQuery {
    @Schema(description = "问题id")
    @NotNull
    Long questionId;
    @Schema(description = "回答id")
    Long answerId;

    /**
     * 判断是评论还是回复
     * @return true 评论； false 回复
     */
    public boolean isComment(){
        return answerId != null && answerId != 0L;
    }
}
