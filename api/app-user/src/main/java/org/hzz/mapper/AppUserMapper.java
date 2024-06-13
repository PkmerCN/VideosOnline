package org.hzz.mapper;

import org.hzz.domain.entity.AppUser;

import java.util.List;

public interface AppUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppUser row);

    AppUser selectByPrimaryKey(Long id);

    List<AppUser> selectAll();

    int updateByPrimaryKey(AppUser row);
}