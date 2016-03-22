package com.newgen.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newgen.core.base.BaseMapper;
import com.newgen.core.bean.Article;
import com.newgen.core.bean.ArticleData;
import com.newgen.core.bean.Role;
import com.newgen.core.bean.RoleMenu;
import com.newgen.yctg.bean.UserInfo;

public interface ArticleMapper extends BaseMapper<Article> {

	void saveArticleData(ArticleData articleData);

	void updateArticleData(ArticleData articleData);

	ArticleData getArticleData(String id);




}
