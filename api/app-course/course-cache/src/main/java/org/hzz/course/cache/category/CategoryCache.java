package org.hzz.course.cache.category;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hzz.common.util.CastUtil;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.domain.service.category.CategoryDomainService;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

/**
 * 分类的一个缓存
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@Component
@RequiredArgsConstructor
public class CategoryCache {
    /**
     * {@code key} -> {@link Key}
     * {@code value} -> Map,Tree,List
     */
    private Cache<String, Object> cache;
    private final CategoryDomainService categoryDomainService;


    @PostConstruct
    public void init() {
        cache = Caffeine.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(Duration.ofMinutes(10))
                .build();
    }


    public List<CategoryEntity> getAllCategoryEntities(){
        Object o = cache.get(Key.ALL, key -> categoryDomainService.getAllCategoryEntities());
        return CastUtil.castList(o, CategoryEntity.class);
    }


    interface Key{
        String ALL = "ALL";
        String ALL_AVAILABLE = "ALL_AVAILABLE";
    }
}
