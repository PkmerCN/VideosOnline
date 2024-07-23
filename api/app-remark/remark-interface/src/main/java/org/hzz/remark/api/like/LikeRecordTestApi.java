package org.hzz.remark.api.like;

import org.hzz.core.result.Result;
import org.hzz.remark.types.BizType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/24
 */
@RequestMapping("/test/like")
public interface LikeRecordTestApi {

    @GetMapping("/{type}")
    default public Result<BizType> testBizType(
            @PathVariable("type") BizType bizType
    ){
        System.out.println("此时的： " + bizType);
        return Result.success(bizType);
    }
}
