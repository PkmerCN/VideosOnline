package org.hzz.cache.converter;

import com.alibaba.fastjson2.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * JSONObject转换
 * 实现类类型自动支持，
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/7
 */
public class JSONObjectUtil {

    public static <T> T convert(Object o,Class<T> clazz){
        if(o instanceof JSONObject jsonObject){
            return jsonObject.to(clazz);
        }
        // Integer,String,或者fastjson2已经做了类型转换，那么直接转换
        return (T)o;
    }

    public static <T> List<T> convertToList(List<Object> list, Class<T> clazz){
        if(list == null || list.isEmpty()){
            return Collections.<T>emptyList();
        }
        List<T> result = new ArrayList<>();
        for(Object o: list){
            result.add(convert(o,clazz));
        }
        return result;
    }

    public static <T> Set<T> convertToSet(Set<Object> set, Class<T> clazz){

        if(set == null || set.isEmpty()){
            return Collections.<T>emptySet();
        }

        return set.stream().map(o -> convert(o, clazz))
                .collect(Collectors.toSet());
    }

    public static <T> Map<String,T> convertToMap(Map<String,Object> map, Class<T> clazz){
        if(map == null || map.isEmpty()){
            return Collections.<String,T>emptyMap();
        }

        Map<String,T> result = new HashMap<>();

        for(Map.Entry<String,Object> entry: map.entrySet()){
            String key = entry.getKey();
            T value = convert(entry.getValue(), clazz);
            result.put(key,value);
        }
        return result;
    }
}