package com.newgen.core.service;

import java.util.List;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.Role;
import com.newgen.core.bean.RoleMenu;
import com.newgen.core.service.base.BaseService;

public interface RoleService extends BaseService<Role> {

	void saveRoleMenu(RoleMenu rm);

	List<RoleMenu> getRoleMenuByRoleID(String id);


	void deleteRoleMenuByRoleID(String id);

	List<Role> getRoleByUserID(String id);


}
