package com.newgen.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.core.mapper.MenuMapper;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.base.BaseServiceImpl;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService{
	@Autowired
	private MenuMapper mapper;
	@Override
	public List<Menu> getListByUser(User user) {
		return mapper.getListByUser(user);
	}
	@Override
	public List<Menu> getUrlWithNoButton(Object object) {
		return mapper.getUrlWithNoButton(object);
	}
	@Override
	public List<Menu> getListByUserWithNoButton(User user) {
		return mapper.getListByUserWithNoButton(user);
	}

}
