package org.hzz.learning.api.controller;

import org.hzz.core.controller.BaseController;
import org.hzz.core.page.PageRequest;
import org.hzz.learning.api.LearningLessonApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@RestController
public class LearningLessonController extends BaseController implements LearningLessonApi {
    @Override
    public void queryUserLessons(PageRequest pageRequest) {
        logger.info("分页查询用户课程");
    }
}
