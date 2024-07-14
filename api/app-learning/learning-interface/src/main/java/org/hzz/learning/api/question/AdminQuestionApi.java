package org.hzz.learning.api.question;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.types.req.question.AdminQuestionPageQuery;
import org.hzz.learning.types.resp.question.AdminQuestionDetailVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * admin 问答api
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@RequestMapping("/admin/questions")
@Tag(name="admin 问答api")
public interface AdminQuestionApi {

    @Operation(description = "分页查询")
    @GetMapping("/page")
    Result<PageResponse<AdminQuestionDetailVo>> questionPageQuery(
            @RequestBody
            AdminQuestionPageQuery pageQuery);

}
