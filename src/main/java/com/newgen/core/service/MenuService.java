package com.newgen.core.service;

import java.util.List;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.core.service.base.BaseService;

public interface MenuService extends BaseService<Menu> {

	List<Menu> getListByUser(User user);

	List<Menu> getUrlWithNoButton(Object object);

	List<Menu> getListByUserWithNoButton(User user);


}
