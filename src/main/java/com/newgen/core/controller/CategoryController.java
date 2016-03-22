package com.newgen.core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.core.bean.Article;
import com.newgen.core.bean.Category;
import com.newgen.core.service.CategoryService;
@RequestMapping("/category")
@Controller
public class CategoryController {
			@Autowired
			CategoryService categoryService;

	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> getArtilceByCategory(HttpServletRequest request,Article article,String pageNow,String pageSize,Model model)
	{
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		List<Category> list = categoryService.queryAll(null);
		for (int i=0; i<list.size(); i++){
			Category e = list.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", e.getId());
				map.put("pId", e.getParentid());
				map.put("name", e.getName());
				//map.put("module", e.getModule());
				mapList.add(map);
			
		}
		return mapList;
		
		
	}
	
	
	@RequestMapping("/addArticleUI")
	public String addArticleUI(){
		
		
		
		
		
		
		return "cms/addArticle";
	}
	
	
	
	
	
	
	
	
	
	
	
}
