package org.hzz.user.infrastructure.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.hzz.user.infrastructure.dao.entity.AppUser;
import org.hzz.user.infrastructure.dao.entity.AppUserExample;

import java.util.List;

public interface AppUserMapper {
    long countByExample(AppUserExample example);

    int deleteByExample(AppUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppUser row);

    int insertSelective(AppUser row);

    List<AppUser> selectByExample(AppUserExample example);

    AppUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") AppUser row, @Param("example") AppUserExample example);

    int updateByExample(@Param("row") AppUser row, @Param("example") AppUserExample example);

    int updateByPrimaryKeySelective(AppUser row);

    int updateByPrimaryKey(AppUser row);
}