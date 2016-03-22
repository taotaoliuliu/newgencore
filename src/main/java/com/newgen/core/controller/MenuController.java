package com.newgen.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.core.bean.Menu;
import com.newgen.core.service.MenuService;
@RequestMapping("/resources")
@Controller
public class MenuController {
			@Autowired
			MenuService resourcesService;

	@RequestMapping("getResources")
	public String getMenu(Model model,String parentId)
	{
		
		
		List<Menu> queryAll = resourcesService.getUrlWithNoButton(null);
		//List<Resources> listAll=	powerService.getAll();
		model.addAttribute("menuList", queryAll);
		model.addAttribute("parentId", parentId);
		
		
		return "sys/menuTree";
	}
}
