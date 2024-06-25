package org.hzz.common.collection;

import java.util.Collection;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
public class CollUtil {

    public static <T> boolean isNotEmpty(Collection<T> collection){
        return !isEmpty(collection);
    }

    public static <T> boolean isEmpty(Collection<T> collection){
        return collection == null || collection.isEmpty();
    }
}
