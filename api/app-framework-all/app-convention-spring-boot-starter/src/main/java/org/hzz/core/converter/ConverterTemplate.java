package org.hzz.core.converter;

import org.mapstruct.factory.Mappers;

/**
 * 抽离公共模版：获取实例
 * @deprecated 不太实用，直接使用Mappers.getMapper(clazz)即可
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
public final class ConverterTemplate {

    public static <T> T getMapper(Class<T> clazz){
        return Mappers.getMapper(clazz);
    }
}
