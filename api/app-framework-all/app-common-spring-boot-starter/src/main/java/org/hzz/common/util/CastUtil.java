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
     * 转换成List
     * @param obj 原始类
     * @param clazz Class类型
     * @return 目标类List
     * @param <T> 目标类
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
