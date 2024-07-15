package org.hzz.course.cache.category;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.collection.CollUtil;
import org.hzz.common.tree.TreeDataUtils;
import org.hzz.common.util.CastUtil;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.domain.service.category.CategoryDomainService;
import org.hzz.course.types.dto.CategoryTreeDto;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分类的一个缓存
 * 包括所有分类，可用分类和已经处理成的树形分类
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@Component
@Slf4j
public class CategoryCache {
    /**
     * {@code key} -> {@link Key}
     * {@code value} -> Map,Tree,List
     */
    private Cache<Key, Object> cache;
    private final CategoryDataProcess categoryDataProcess = new CategoryDataProcess();
    private final CategoryDomainService categoryDomainService;
    private final CategoryConvert categoryConvert;

    public CategoryCache(CategoryDomainService categoryDomainService,
                         CategoryConvert categoryConvert){
        this.categoryDomainService = categoryDomainService;
        this.categoryConvert = categoryConvert;
    }

    @PostConstruct
    public void init() {

        cache = Caffeine.newBuilder()
                .maximumSize(10)
                .removalListener(new CacheRemovalListener())
                .expireAfterWrite(Duration.ofMinutes(30)) // 缓存30分钟
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
     * 获取所有分类的map
     * @return 分类map key -> id value -> {@link CategoryEntity}
     */
    public Map<Long,CategoryEntity> categoryAsMap(){
        // 用全部的分类
        List<CategoryEntity> entities = getAllCategoryEntities();
        if(entities == null || entities.isEmpty()){
            return Collections.emptyMap();
        }
        return entities.stream().collect(Collectors.toMap(CategoryEntity::getId,e -> e));
    }

    /**
     * 获取所有可用的分类
     * @return 分类列表
     */
    public List<CategoryEntity> getAvailableCategoryEntities(){
        Object o = cache.get(Key.ALL, key -> categoryDomainService.getAvailableCategoryEntities());
        return CastUtil.castList(o, CategoryEntity.class);
    }


    /**
     * 获取可用分类的树形结构,只包含没有被禁用的分类
     * @return 树形列表，其中列表都是一级目录，一级目录的属性children是二级目录，依次类推
     */
    public List<CategoryTreeDto> getAvailableTreeCategory(){
        log.info("从CategoryCache获取所有可用分类的树形结构");
        Object o = cache.get(Key.ALL_AVAILABLE_Tree, key -> {
            List<CategoryEntity> entities = getAvailableCategoryEntities();
            return TreeDataUtils.parseToTree(entities, categoryConvert, categoryDataProcess);
        });
        return CastUtil.castList(o, CategoryTreeDto.class);
    }

    /**
     * 获取所有分类的树形结构
     * @return 树形列表，其中列表都是一级目录，一级目录的属性children是二级目录，依次类推
     */
    public List<CategoryTreeDto>  getAllTreeCategory(){
        log.info("从CategoryCache获取所有分类的树形结构");
        Object o = cache.get(Key.ALL_Tree, key -> {
            List<CategoryEntity> entities = getAllCategoryEntities();
            return TreeDataUtils.parseToTree(entities, categoryConvert, categoryDataProcess);
        });
        return CastUtil.castList(o, CategoryTreeDto.class);
    }


    /**
     * 缓存失效
     */
    public void invalidateCache(){
        log.info("invalidate all category cache");
        cache.invalidateAll();
    }

    /**
     * 获取分类名称
     * @param ids 分类id
     * @return 一级分类/二级分类/三级分类
     */
    public String getCategoryName(List<Long> ids){
        if(CollUtil.isEmpty(ids)){
            return "";
        }
        Map<Long, CategoryEntity> categoryEntityMap = categoryAsMap();
        StringBuilder strContainer = new StringBuilder();
        for (Long id: ids){
            CategoryEntity categoryEntity = categoryEntityMap.get(id);
            if(categoryEntity == null){
                break;
            }
            String name = categoryEntity.getName();
            strContainer.append(name);
            strContainer.append("/");
        }
        return strContainer.deleteCharAt(strContainer.length() - 1).toString();
    }

    public enum Key{
        ALL("全部分类List"),
        ALL_AVAILABLE("可用的全部分类List"),
        ALL_Tree("全部分类层级树状"),
        ALL_AVAILABLE_Tree("可用的全部分类层级树状");

        Key(String desc){}
    }
}
