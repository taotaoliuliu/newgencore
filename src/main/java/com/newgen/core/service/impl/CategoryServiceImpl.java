package com.newgen.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.core.bean.Category;
import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.core.mapper.CategoryMapper;
import com.newgen.core.mapper.MenuMapper;
import com.newgen.core.service.CategoryService;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.base.BaseServiceImpl;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{
	@Autowired
	private CategoryMapper mapper;
	
}
