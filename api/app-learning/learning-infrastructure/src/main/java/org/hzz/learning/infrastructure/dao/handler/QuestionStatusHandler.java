package org.hzz.learning.infrastructure.dao.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.hzz.learning.types.enums.question.QuestionStatus;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * status 与 {@link QuestionStatus}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Slf4j
public class QuestionStatusHandler extends BaseTypeHandler<QuestionStatus> {
    public QuestionStatusHandler(){
        super();
        log.info("QuestionStatusHandler已就位");
    }
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, QuestionStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setByte(i,parameter.getValue().byteValue());
    }

    @Override
    public QuestionStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Byte status = rs.getByte(columnName);
        return QuestionStatus.fromValue(status);
    }

    @Override
    public QuestionStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Byte status = rs.getByte(columnIndex);
        return rs.wasNull() ? QuestionStatus.UN_CHECK : QuestionStatus.fromValue(status);
    }

    @Override
    public QuestionStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Byte status = cs.getByte(columnIndex);
        return cs.wasNull() ? QuestionStatus.UN_CHECK : QuestionStatus.fromValue(status);
    }
}
