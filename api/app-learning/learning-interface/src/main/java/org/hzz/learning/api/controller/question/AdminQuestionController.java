package org.hzz.learning.api.controller.question;

import org.hzz.core.controller.BaseController;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.api.AdminQuestionApi;
import org.hzz.learning.types.req.question.AdminQuestionPageQuery;
import org.hzz.learning.types.resp.question.AdminQuestionDetailVo;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@RestController
public class AdminQuestionController extends BaseController
    implements AdminQuestionApi
{
    @Override
    public Result<PageResponse<AdminQuestionDetailVo>> questionPageQuery(AdminQuestionPageQuery pageQuery) {
        return null;
    }
}
