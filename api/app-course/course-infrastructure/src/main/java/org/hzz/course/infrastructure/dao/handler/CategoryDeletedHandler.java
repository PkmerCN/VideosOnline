package org.hzz.course.infrastructure.dao.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.hzz.core.enums.delete.Deleted;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis处理逻辑删除{@link Deleted}枚举
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public class CategoryDeletedHandler extends BaseTypeHandler<Deleted> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Deleted parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i,parameter.getValue().byteValue());
    }

    @Override
    public Deleted getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Byte status = rs.getByte(columnName);
        return Deleted.fromValue(status);
    }

    @Override
    public Deleted getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Byte status = rs.getByte(columnIndex);
        return Deleted.fromValue(status);
    }

    @Override
    public Deleted getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Byte status = cs.getByte(columnIndex);
        return Deleted.fromValue(status);
    }
}
