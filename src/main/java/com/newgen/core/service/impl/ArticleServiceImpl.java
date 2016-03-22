package com.newgen.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.core.bean.Article;
import com.newgen.core.bean.ArticleData;
import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.core.mapper.ArticleMapper;
import com.newgen.core.mapper.MenuMapper;
import com.newgen.core.service.ArticleService;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.base.BaseServiceImpl;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService{
	@Autowired
	private ArticleMapper mapper;

	@Override
	public void saveArticleData(ArticleData articleData) {
		mapper.saveArticleData(articleData);
	}

	@Override
	public void updateArticleData(ArticleData articleData) {
		mapper.updateArticleData(articleData);
	}

	@Override
	public ArticleData getArticleData(String id) {
		
		return 		mapper.getArticleData(id);

	}
	

}
