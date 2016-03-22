package com.newgen.core.service;

import java.util.List;

import com.newgen.core.bean.Article;
import com.newgen.core.bean.ArticleData;
import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.core.service.base.BaseService;

public interface ArticleService extends BaseService<Article> {

	void saveArticleData(ArticleData articleData);

	void updateArticleData(ArticleData articleData);

	ArticleData getArticleData(String id);



}
