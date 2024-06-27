package org.hzz.mybatis.core;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.hzz.mybatis.annotation.SnowflakeId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 拦截insert生成雪花算法
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Intercepts(
    @Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class})
)
public class SnowflakeIdPlugin implements Interceptor {
    private final Logger logger = LoggerFactory.getLogger(SnowflakeIdPlugin.class);
    private final SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(1,1);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        //args数组对应对象就是上面@Signature注解中args对应的对应类型
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];

        if(mappedStatement.getSqlCommandType().equals(SqlCommandType.INSERT)){
            logger.info("SnowflakeIdPlugin插件拦截{}，生成雪花算法id中",SqlCommandType.INSERT);
            List<Object> entities = getEntityObject(parameter);
            for (Object e: entities){
                setSnowflakeId(e);
            }
        }
        return invocation.proceed();
    }

    /**
     * 解析参数，因为mybatis会将参数进行封装，我们需要提取出来
     * @param object mybatis封装的参数
     * @return 解析出来我们原始的变量
     */
    private List<Object> getEntityObject(Object object) {
        List<Object> entities = new ArrayList<>();
        if (object instanceof Map<?, ?> map) {
            // Batch insert (批量操作)
            final String LIST_KEY = "list";
            Object listObject = map.get(LIST_KEY);

            if (listObject instanceof List<?> values) {
                for (Object v : values) {
                    if (v instanceof List<?>) {
                        entities.addAll((List<?>) v);
                    } else {
                        entities.add(v);
                    }
                }
            }
        }else{
            // 单个对象
            entities.add(object);
        }
        return entities;
    }

    private void setSnowflakeId(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for(Field field: declaredFields){
            if(field.isAnnotationPresent(SnowflakeId.class)){
                logger.info("检测到{}中{}属性有@SnowflakeId注解",
                        object.getClass().getSimpleName(),
                        field.getName());
                field.setAccessible(true);
                if(field.get(object) == null){
                    field.set(object,snowflakeIdGenerator.nextId());
                }
            }
        }
    }
}
