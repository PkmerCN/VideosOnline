package org.hzz.points.types.constants;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
public interface RedisConstants {

    /**
     * sign::uid::1::20240728
     */
    String SIGN_RECORD_TEMPLATE = "sign::uid::{}::{}";

    /**
     * 积分排行榜
     * boards::202408
     */
    String BOARDS_TEMPLATE = "boards::{}";
}
