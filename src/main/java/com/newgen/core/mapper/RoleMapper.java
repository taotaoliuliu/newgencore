package com.newgen.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newgen.core.base.BaseMapper;
import com.newgen.core.bean.Role;
import com.newgen.core.bean.RoleMenu;
import com.newgen.yctg.bean.UserInfo;

public interface RoleMapper extends BaseMapper<Role> {

	void saveRoleMenu(RoleMenu rm);

	List<RoleMenu> getRoleMenuByRoleID(String id);

	void deleteRoleMenuByRoleID(String id);

	List<Role> getRoleByUserID(String userid);





}
