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
 * 数据库类型为tinyint对应的类型枚举处理模版
 * @param <T> 对应的具体枚举类型
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@MappedJdbcTypes(JdbcType.TINYINT)
public abstract class ByteTypeHandler<T extends BaseEnum> extends BaseTypeHandler<T> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i,parameter.getValue().byteValue());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Byte status = rs.getByte(columnName);
        return fromValue(status);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Byte status = rs.getByte(columnIndex);
        return rs.wasNull() ? null: fromValue(status);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Byte status = cs.getByte(columnIndex);
        return cs.wasNull() ? null: fromValue(status);
    }

    abstract T fromValue(Byte value);
}
