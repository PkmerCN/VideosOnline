package org.hzz.cache.core;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.*;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hzz.cache.converter.JSONObjectUtil.*;

/**
 * RedisTemplate封装
 * 使用FastJson
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Slf4j
public class RedisCacheImpl implements RedisCache{
    private final RedisTemplate redisTemplate;

    /**
     * 因为自动配置类会配置一个stringRedisTemplate
     * @param redisTemplate 模板
     */
    public RedisCacheImpl(@Qualifier("redisTemplate") RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setObject(String key, T value) {
        log.info("插入字符串: {}",value.toString());
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setObject(String key, T value, Long timeout, TimeUnit timeUnit) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value,timeout,timeUnit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setObject(String key, T value, Long timeout) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value,timeout,TimeUnit.SECONDS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getObject(String key,Class<T> clazz) {
        log.info("根据 key = {} 获取",key);
        Object o = redisTemplate.opsForValue().get(key);
        return convert(o,clazz);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteObject(String key) {
        log.info("删除缓存 key = {}",key);
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public long deleteObject(Collection<?> keys) {
        Long delete = redisTemplate.delete(keys);
        return delete == null ? 0L: delete;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean expire(String key, long timeout) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, TimeUnit.SECONDS));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean expire(String key, Duration duration) {
        return Boolean.TRUE.equals(redisTemplate.expire(key,duration));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, unit));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> long setList(String key, List<T> dataList) {
        log.info("插入List 元素{}个",dataList.size());
        ListOperations<String,T> listOperations = redisTemplate.opsForList();
        Long r = listOperations.leftPushAll(key,dataList);
        return r == null ? 0: r;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> getList(String key,Class<T> clazz) {
        log.info("获取List");
        List<Object> range = redisTemplate.opsForList().range(key, 0, -1);
        return convertToList(range,clazz);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> long setSet(String key, Set<T> dataSet) {
        log.info("设置set");
        SetOperations<String,T> setOperations = redisTemplate.opsForSet();
        T[] array = (T[])dataSet.toArray(new Object[0]);
        Long r = setOperations.add(key,array);
        return r == null ? 0:r;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Set<T> getSet(String key,Class<T> clazz) {
        Set<Object> members = redisTemplate.opsForSet().members(key);
        return convertToSet(members,clazz);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setMap(String key, Map<String, T> dataMap) {
        log.info("插入hash");
        HashOperations<String,String,T> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key,dataMap);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Map<String, T> getMap(String key,Class<T> clazz) {
        Map<String, Object> entries = redisTemplate.opsForHash().entries(key);
        return convertToMap(entries,clazz);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setMapValue(String key, String hKey, T value) {
        log.info("设置hash key = {} hashKey = {}",key,hKey);
        HashOperations<String,String,T> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key,hKey,value);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getMapValue(String key, String hKey,Class<T> clazz) {
        Object o = redisTemplate.opsForHash().get(key, hKey);
        return convert(o,clazz);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Long delMapValue(String key, String hkey) {
        Long r = redisTemplate.opsForHash().delete(key, hkey);
        return r == null ? 0 : r;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> getMultiCacheMapValue(String key, Collection<String> hKeys,Class<T> clazz) {

        List<Object> ts = redisTemplate.opsForHash().multiGet(key, hKeys);
        return convertToList(ts,clazz);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

}
