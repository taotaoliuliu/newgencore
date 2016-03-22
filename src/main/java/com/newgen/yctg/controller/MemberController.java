package com.newgen.yctg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.newgen.core.bean.Menu;
import com.newgen.core.plugin.PageView;
import com.newgen.core.service.MenuService;

import com.newgen.yctg.bean.UserInfo;
import com.newgen.yctg.service.MemberService;
import com.newgen.yctg.utils.PageUtil;
import com.newgen.yctg.utils.UninewsTools;

@Controller
@RequestMapping("/mem")
public class MemberController {
	
		@Autowired
		MemberService userService;
		
		@Autowired
		MenuService resourcesService;

	
	
	
	@RequestMapping("getPageUser")
	public String getPageUser(HttpServletRequest request,UserInfo user,String pageNow,String pageSize,Model model){
		
		
		PageView pageview=	userService.getPageList(PageUtil.getPageView(pageNow, pageSize),user);
		
		model.addAttribute("pageview",pageview);
		
		
		return "user/listuser";
		
		
		
	}

}
