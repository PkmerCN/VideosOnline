package org.hzz.cache.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis缓存接口
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
public interface RedisCache {

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     */
    <T> void setObject(final String key, final T value);

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param timeout  时间
     * @param timeUnit 时间颗粒度
     */
    <T> void setObject(final String key, final T value, final Long timeout, final TimeUnit timeUnit);

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param timeout  时间(默认秒)
     */
    <T> void setObject(final String key, final T value, final Long timeout);

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @param clazz 要转换的类型
     * @return 缓存键值对应的数据
     */
    <T> T getObject(final String key,Class<T> clazz);

    /**
     * 删除单个对象
     *
     * @param key
     */
    boolean deleteObject(final String key);

    /**
     * 删除集合对象
     *
     * @param keys 多个对象
     * @return 删除的对象数目
     */
    long deleteObject(final Collection<?> keys);

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间(默认为秒)
     * @return true=设置成功；false=设置失败
     */
    boolean expire(final String key, final long timeout);

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return true=设置成功；false=设置失败
     */
    boolean expire(final String key, final long timeout, final TimeUnit unit);


    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象数量
     */
    <T> long setList(final String key, final List<T> dataList);

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @param clazz 转换类型
     * @return 缓存键值对应的数据
     */
    <T> List<T> getList(final String key,Class<T> clazz);


    /**
     * 缓存Set
     *
     * @param key     缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    <T> long setSet(final String key, Set<T> dataSet);

    /**
     * 获得缓存的set
     *
     * @param key 缓存键值
     * @param clazz 要转换的类型
     * @return Set数据
     */
    <T> Set<T> getSet(final String key,Class<T> clazz);

    /**
     * 缓存Map
     *
     * @param key 缓存键值
     * @param dataMap 缓存的数据
     */
    <T> void setMap(final String key, final Map<String, T> dataMap);

    /**
     * 获得缓存的Map
     *
     * @param key 缓存键值
     * @param clazz 要转换的类型
     * @return Map数据
     */
    <T> Map<String, T> getMap(final String key,Class<T> clazz);

    /**
     * 往Hash中存入数据
     *
     * @param key   Redis键
     * @param hKey  Hash键
     * @param value 值
     */
    <T> void setMapValue(final String key, final String hKey, final T value);

    /**
     * 获取Hash中的数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @param clazz 要转换的类型
     * @return Hash中的对象
     */
    <T> T getMapValue(final String key, final String hKey,Class<T> clazz);

    /**
     * 删除Hash中的数据
     *
     * @param key Redis键
     * @param hkey Hash键
     */
    Long delMapValue(final String key, final String hkey);

    /**
     * 获取多个Hash中的数据
     *
     * @param key   Redis键
     * @param hKeys Hash键集合
     * @param clazz 要转换的类型
     * @return Hash对象集合
     */
    <T> List<T> getMultiCacheMapValue(final String key, final Collection<String> hKeys,Class<T> clazz);

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    Collection<String> keys(final String pattern);
}
