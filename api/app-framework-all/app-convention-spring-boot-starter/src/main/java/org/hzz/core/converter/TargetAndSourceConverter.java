package org.hzz.core.converter;

import org.hzz.core.page.PageResponse;

import java.util.List;

/**
 * 通用各层转换，于Mapstruct的具体转换继承
 * @param <T> 转换成的目标
 * @param <S> 原始类
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
public interface TargetAndSourceConverter<T,S> {
    T toTarget(S source);

    List<T> toTargets(List<S> sources);

    S toSource(T target);

    List<S> toSources(List<T> targets);

    /**
     * @param pageResponse S类型的分页数据
     * 分页转化
     * @return T 类型的分页数据
     */
    PageResponse<T> convertToTargetPage(PageResponse<S> pageResponse);

    /**
     * @param pageResponse T类型的分页数据
     * 分页转化
     * @return S实际类的分页数据
     */
    PageResponse<S> convertToSourcePage(PageResponse<T> pageResponse);
}
