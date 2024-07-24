package org.hzz.core.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.hzz.core.enums.BaseEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库类型为int对应的类型枚举处理模版
 * @param <T> 对应的具体枚举类型
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@MappedJdbcTypes(JdbcType.INTEGER)
public abstract class IntTypeHandler<T extends BaseEnum<Integer>> extends BaseTypeHandler<T> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getValue());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return fromValue(value);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return fromValue(value);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return cs.wasNull() ? null: fromValue(value);
    }

    protected abstract T fromValue(Integer value);
}
