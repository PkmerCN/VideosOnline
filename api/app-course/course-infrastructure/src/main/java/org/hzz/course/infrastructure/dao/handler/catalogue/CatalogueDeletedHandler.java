package org.hzz.course.infrastructure.dao.handler.catalogue;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.hzz.core.enums.delete.Deleted;
import org.hzz.core.handler.ByteTypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 章节是否逻辑删除处理
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
public class CatalogueDeletedHandler  extends ByteTypeHandler<Deleted> {
    @Override
    protected Deleted fromValue(Byte value) {
        return Deleted.fromValue(value);
    }
}
