package org.hzz.course.cache.category;

import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@Slf4j
public class CacheRemovalListener implements RemovalListener<CategoryCache.Key,Object> {
    @Override
    public void onRemoval(CategoryCache.@Nullable Key key, @Nullable Object value, RemovalCause cause) {
        log.info("key = {} {}",key,cause);
    }
}
