package org.hzz.common.util;

import java.util.List;

/**
 * 类型转化工具类
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
public class CastUtil {

    /**
     * todo 进行一个强转工具抽象
     * @param obj
     * @param clazz
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        if (obj instanceof List<?> list) {
            for (Object item : list) {
                if (!clazz.isInstance(item)) {
                    throw new ClassCastException("List contains elements of different types");
                }
            }
            return (List<T>) list;
        } else {
            throw new ClassCastException("Object is not a List");
        }
    }
}
