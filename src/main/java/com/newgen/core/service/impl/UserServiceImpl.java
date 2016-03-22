package com.newgen.core.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.Role;
import com.newgen.core.bean.RoleMenu;
import com.newgen.core.bean.User;
import com.newgen.core.bean.UserRole;
import com.newgen.core.mapper.RoleMapper;
import com.newgen.core.mapper.UserMapper;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.RoleService;
import com.newgen.core.service.UserService;
import com.newgen.core.service.base.BaseServiceImpl;
import com.newgen.yctg.bean.UserInfo;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	@Autowired
	UserMapper mapper;

	@Override
	public User getUserByNameAndPassword(String loginname, String password) {
		return mapper.getUserByNameAndPassword(loginname,password);
	}

	@Override
	public User getUserByLoginName(String loginname) {
		
		
		return mapper.getUserByLoginName(loginname);
	}

	@Override
	public void saveUserRole(UserRole ur) {
		 mapper.saveUserRole(ur);

	}




}
