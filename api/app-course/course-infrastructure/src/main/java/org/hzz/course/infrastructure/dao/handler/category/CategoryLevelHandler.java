package org.hzz.course.infrastructure.dao.handler.category;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.hzz.course.types.enums.catagory.CategoryLevel;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis处理{@link CategoryLevel }枚举类型
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public class CategoryLevelHandler extends BaseTypeHandler<CategoryLevel> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CategoryLevel parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getValue());
    }

    @Override
    public CategoryLevel getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return CategoryLevel.fromValue(value);
    }

    @Override
    public CategoryLevel getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return CategoryLevel.fromValue(value);
    }

    @Override
    public CategoryLevel getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return cs.wasNull() ? null: CategoryLevel.fromValue(value);
    }
}
