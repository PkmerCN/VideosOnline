package org.hzz.course.cache.category;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.util.CastUtil;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.domain.service.category.CategoryDomainService;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

/**
 * 分类的一个缓存
 * 包括所有分类，可用分类和已经处理成的树形分类
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryCache {
    /**
     * {@code key} -> {@link Key}
     * {@code value} -> Map,Tree,List
     */
    private Cache<Key, Object> cache;
    private final CategoryDomainService categoryDomainService;


    @PostConstruct
    public void init() {
        cache = Caffeine.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(Duration.ofMinutes(10))
                .build();
    }

    @PreDestroy
    public void destroy(){
        cache.invalidateAll();
    }


    /**
     * 获取所有分类
     * @return 分类列表
     */
    public List<CategoryEntity> getAllCategoryEntities(){
        Object o = cache.get(Key.ALL, key -> categoryDomainService.getAllCategoryEntities());
        return CastUtil.castList(o, CategoryEntity.class);
    }

    /**
     * 获取所有可用的分类
     * @return 分类列表
     */
    public List<CategoryEntity> getAvailableCategoryEntities(){
        Object o = cache.get(Key.ALL, key -> categoryDomainService.getAvailableCategoryEntities());
        return CastUtil.castList(o, CategoryEntity.class);
    }


    public void invalidateCache(){
        log.info("invalidate all category cache");
        cache.invalidateAll();
    }

    enum Key{
        ALL("全部分类List"),
        ALL_AVAILABLE("可用的全部分类List"),
        ALL_AVAILABLE_Tree("可用的全部分类层级树状");

        Key(String desc){}
    }
}
