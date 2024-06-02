package org.hzz.mapper;

import java.util.List;
import org.hzz.model.AppUser;

public interface AppUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppUser row);

    AppUser selectByPrimaryKey(Long id);

    List<AppUser> selectAll();

    int updateByPrimaryKey(AppUser row);
}