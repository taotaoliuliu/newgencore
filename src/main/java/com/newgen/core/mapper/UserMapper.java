package com.newgen.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.newgen.core.base.BaseMapper;
import com.newgen.core.bean.User;
import com.newgen.core.bean.UserRole;

public interface UserMapper extends BaseMapper<User> {

	User getUserByNameAndPassword(@Param(value = "loginname") String loginname, @Param(value = "password")String password);

	User getUserByLoginName(String loginname);

	void saveUserRole(UserRole ur);

}
