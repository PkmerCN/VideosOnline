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
import java.util.List;

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
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];

        if(mappedStatement.getSqlCommandType().equals(SqlCommandType.INSERT)){
            logger.info("SnowflakeIdPlugin插件拦截{}，生成雪花算法id中",SqlCommandType.INSERT);
            if(parameter instanceof List){
                List<?> list = (List<?>)parameter;
                for (Object object: list){
                    setSnowflakeId(object);
                }
            }else{
                setSnowflakeId(parameter);
            }
        }
        return invocation.proceed();
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
