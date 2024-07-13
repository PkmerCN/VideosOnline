package org.hzz.course.infrastructure.dao.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.hzz.course.types.enums.CategoryStatus;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis处理{@link CategoryStatus}枚举类型
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public class CategoryStatusHandler extends BaseTypeHandler<CategoryStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CategoryStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i,parameter.getValue().byteValue());
    }

    @Override
    public CategoryStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Byte status = rs.getByte(columnName);
        return CategoryStatus.fromValue(status);
    }

    @Override
    public CategoryStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Byte status = rs.getByte(columnIndex);
        return rs.wasNull() ? null: CategoryStatus.fromValue(status);
    }

    @Override
    public CategoryStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Byte status = cs.getByte(columnIndex);
        return cs.wasNull() ? null: CategoryStatus.fromValue(status);
    }
}
