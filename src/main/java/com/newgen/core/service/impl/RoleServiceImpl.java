package com.newgen.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.Role;
import com.newgen.core.bean.RoleMenu;
import com.newgen.core.mapper.RoleMapper;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.RoleService;
import com.newgen.core.service.base.BaseServiceImpl;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	@Autowired
	RoleMapper mapper;

	@Override
	public void saveRoleMenu(RoleMenu rm) {
		
		
		mapper.saveRoleMenu(rm);
	}

	@Override
	public List<RoleMenu> getRoleMenuByRoleID(String id) {
		return	mapper.getRoleMenuByRoleID(id);
	}

	@Override
	public void deleteRoleMenuByRoleID(String id) {
		mapper.deleteRoleMenuByRoleID(id);		
	}

	@Override
	public List<Role> getRoleByUserID(String userid) {
	return	mapper.getRoleByUserID(userid);		
	}


}
