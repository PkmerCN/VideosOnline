package org.hzz.user.infrastructure.dao.mapper.details;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzz.user.infrastructure.dao.entity.details.UserDetail;
import org.hzz.user.infrastructure.dao.entity.details.UserDetailExample;

public interface UserDetailMapper {
    long countByExample(UserDetailExample example);

    int deleteByExample(UserDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDetail row);

    int insertSelective(UserDetail row);

    List<UserDetail> selectByExample(UserDetailExample example);

    UserDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UserDetail row, @Param("example") UserDetailExample example);

    int updateByExample(@Param("row") UserDetail row, @Param("example") UserDetailExample example);

    int updateByPrimaryKeySelective(UserDetail row);

    int updateByPrimaryKey(UserDetail row);
}