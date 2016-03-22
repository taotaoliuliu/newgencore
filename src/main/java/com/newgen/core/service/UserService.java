package com.newgen.core.service;

import java.util.List;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.core.bean.UserRole;
import com.newgen.core.service.base.BaseService;
import com.newgen.yctg.bean.UserInfo;

public interface UserService extends BaseService<User> {

	User getUserByNameAndPassword(String name_Login, String password);

	User getUserByLoginName(String loginname);

	void saveUserRole(UserRole ur);


}
