package org.hzz.common.tree;

import java.util.*;

/**
 * 通用树形数据处理工具设计
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
public class TreeDataUtils {

    /**
     * 根据数据之间的父子关系将原始数据列表转化成树型数据，并将数据转化成目标类型
     * 适用场景 每一条数据都有一个唯一标识和父数据的唯一标识
     *
     * @param originData    原始数据，列表
     * @param convert       原始类与目标类转化 {@link BaseConverter} 基于mapstruct
     * @param dataProcessor 树形数据包装器 用于结构具体类的操作。具体类的处理需要实现{@link DataProcessor}
     * @param <T>           原始数据的类型
     * @param <R>           目标数据的类型
     * @return 目标数据类型的树状数据
     */
    public static <R, T> List<R> parseToTree(List<T> originData, BaseConverter<R,T> convert, DataProcessor<R, T> dataProcessor) {
        return parseToTree(originData,convert,dataProcessor,new DefaultFilter<T>());
    }


    /**
     * 根据数据之间的父子关系将原始数据列表转化成树型数据，并将数据转化成目标类型
     * 适用场景 每一条数据都有一个唯一标识和父数据的唯一标识
     *
     * @param originData    原始数据，列表
     * @param converter     原始类与目标类转化 {@link BaseConverter} 基于mapstruct
     * @param dataProcessor 树形数据包装器 用于结构具体类的操作。具体类的处理需要实现{@link DataProcessor}
     * @param filter        过滤器
     * @param <T>           原始数据的类型
     * @param <R>           目标数据的类型
     * @return 目标数据类型的树状数据
     */
    public static <R, T> List<R> parseToTree(List<T> originData, BaseConverter<R,T> converter, DataProcessor<R, T> dataProcessor, Filter<T> filter) {

        Map<Object,R> resultMap = new HashMap<>();

        for (T element: originData){

            if(!filter.filter(element)){
                continue;
            }

            R current = converter.convert(element);
            dataProcessor.setChild(current,new ArrayList<>());

            // 处理这个节点的父节点
            Object parentKey = dataProcessor.getParentKey(element);
            R parent = resultMap.get(parentKey);

            if(parent == null){
                /*
                 * 此时还没map中还没有此节点的父节点
                 * 所以创建一个伪父节点，用来持有这个子节点
                 * 当处理到这个节点的父节点是，直接从这个伪父节点拿出children更新即可
                 * 最后放入更新的父节点到map中
                 */
                parent = dataProcessor.createNewObject();
                dataProcessor.setChild(parent,new ArrayList<>());
            }
            // 将本次节点加入父节点
            dataProcessor.addChildElement(parent,current);

            // 处理这个节点的children,因为在处理到当前节点前它的子节点已经加入了容器(存储在一个伪节点)。
            Object key = dataProcessor.getKey(element);
            R currentInMap = resultMap.get(key);
            if(currentInMap != null){
                List<R> child = dataProcessor.getChild(currentInMap);
                dataProcessor.setChild(current,child);
            }

            resultMap.put(dataProcessor.getParentKey(element),parent);
            // 本次节点可能也会成为其他节点的父节点，所以也要放入map
            resultMap.put(dataProcessor.getKey(element),current);
        }

        R r = resultMap.get(dataProcessor.getRootKey());
        return r == null ? Collections.emptyList() : dataProcessor.getChild(r);
    }


    /**
     * 树形数据处理器
     *
     * @param <T> 原始数据
     * @param <R> 目标数据
     */
    public interface DataProcessor<R, T> {
        /**
         * 从当前数据中获取父数据的key，也就是和父数据的关系
         *
         * @param t
         * @return
         */
        Object getParentKey(T t);

        /**
         * 获取当前数据的标识
         *
         * @param t
         * @return
         */
        Object getKey(T t);

        /**
         * 获取整个树的根数据
         *
         * @return
         */
        Object getRootKey();

        /**
         * 获取子数据列表
         *
         * @param r
         * @return
         */
        List<R> getChild(R r);

        /**
         * 将子数据列表放入到父数据中
         *
         * @param parent
         * @param child
         */
        void setChild(R parent, List<R> child);

        /**
         * 添加子节点
         * @param parent 父节点
         * @param childElement 子节点
         */
        void addChildElement(R parent,R childElement);

        /**
         * 创建一个新目标类
         * 主要用于做伪父节点
         * @return R 目标类
         */
        R createNewObject();

    }


    /**
     * 过滤器
     * @param <T>
     */
    public interface Filter<T>{
        default boolean filter(T t){
            return true;
        }
    }

    public static class DefaultFilter<T> implements Filter<T>{
    }
}
