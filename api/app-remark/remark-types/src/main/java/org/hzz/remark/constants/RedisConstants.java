package org.hzz.remark.constants;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
public interface RedisConstants {

    /**
     * likes:set:biz:1
     * likes:set:biz:+业务id
     */
    String TEMPLATE_KEY = "likes:set:biz:{}";

    /**
     * 业务点赞总数，缓存key模版
     * liked:times:QA
     */
    String LIKES_TIMES_KEY = "liked:times:{}";
}
