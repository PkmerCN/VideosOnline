package org.hzz.controller;

import org.hzz.cache.core.RedisCache;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试redis生效
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/8
 */
@RestController
@RequestMapping("/test/redis")
public class RedisTestController extends BaseController {
    @Cacheable(value = "app",key = "#id")
    @GetMapping("/{id}")
    public Result<Object> test(@PathVariable Integer id){
        logger.info("id = {}",id);
        Map<String,String> payload = Map.of("msg","Hello pkmer");
        return success(payload);
    }
}
