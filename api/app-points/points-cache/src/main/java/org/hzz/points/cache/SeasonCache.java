package org.hzz.points.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.domain.service.points.PointsBoardSeasonDomainService;
import org.hzz.points.types.resp.SeasonVo;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

/**
 * 赛季数据管理
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SeasonCache {
    public static final String all_season_key = "all_season";

    private final PointsBoardSeasonDomainService seasonDomainService;
    private final SeasonVoConverter converter;
    private LoadingCache<String, List<SeasonVo>> cache;


    @PostConstruct
    public void init(){
        cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(Duration.ofMinutes(30))
                .build(this::getCacheLoader);
    }

    private List<SeasonVo> getCacheLoader(String key){
        log.info("从JVM缓存caffine中获取 key = {} 的数据",key);
        List<PointsBoardSeasonEntity> allSeason = seasonDomainService.getAllSeason();
        return converter.toTargets(allSeason);
    }

    public List<SeasonVo> getAllSeason(){
        List<SeasonVo> seasonVos = cache.get(all_season_key);
        log.info("从缓存获取到赛季数据：{}条",seasonVos.size());
        return seasonVos;
    }
}
