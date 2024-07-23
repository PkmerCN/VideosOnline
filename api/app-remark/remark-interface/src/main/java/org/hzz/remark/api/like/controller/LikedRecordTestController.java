package org.hzz.remark.api.like.controller;

import jakarta.annotation.PostConstruct;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.remark.api.like.LikeRecordTestApi;
import org.hzz.remark.types.BizType;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/24
 */
@RestController
public class LikedRecordTestController
        extends BaseController
        implements LikeRecordTestApi {


    @PostConstruct
    public void init(){
        logger.info("LikedRecordTestController init");
    }

    @Override
    public Result<BizType> testBizType(BizType bizType) {
        return LikeRecordTestApi.super.testBizType(bizType);
    }
}
