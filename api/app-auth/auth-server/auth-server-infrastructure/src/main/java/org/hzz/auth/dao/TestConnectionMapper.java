package org.hzz.auth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Mapper
public interface TestConnectionMapper {
    @Select("select DATABASE()")
    String testConnection();
}
