package com.newgen.yctg.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.Role;
import com.newgen.core.bean.User;
import com.newgen.core.bean.UserRole;
import com.newgen.core.plugin.PageView;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.RoleService;
import com.newgen.core.service.UserService;
import com.newgen.core.utils.CacheUtils;
import com.newgen.yctg.bean.UserInfo;
import com.newgen.yctg.utils.DateUtil;
import com.newgen.yctg.utils.PageUtil;
import com.newgen.yctg.utils.UninewsTools;



@RequestMapping("/angu")
@Controller
public class AnguController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;

	@ResponseBody
	@RequestMapping("/getList")
	public JSONObject getList(HttpServletRequest request,User user,String pageNow,String pageSize,Model model){
		
		JSONObject jsonObject =new JSONObject();
		
		PageView<User> pageview=	userService.getPageList(PageUtil.getPageView(pageNow, pageSize),user);
		
		
		List<User> records = pageview.getRecords();
		
		if(records!=null&&records.size()>0)
		{
			
			for(User u :records)
			{
			List<Role> list =roleService.getRoleByUserID(u.getId());	
			String rolename="";
			
			for(Role r : list)
			{
				rolename+=r.getName()+"  ";
				
			}
			
			u.setRolename(rolename);

				
			}
		}
		
		
		
		JSONObject fromObject = JSONObject.fromObject(pageview);
		
		model.addAttribute("pageview",pageview);
		model.addAttribute("user", user);
		
		
		
		
		return fromObject;
	}
	
	
	@RequestMapping("/index")
	public String index(){
		
		
		return "angu/listuser";
	}
	
	
	
	
	
	@RequestMapping("/addUI")
	public String addUI(Model model){
		
		
		List<Role> listRole = roleService.queryAll(null);
		
		
		model.addAttribute("listRole", listRole);
		
		
		return "sys/adduser";
	
	}
	@RequestMapping("/save")
	public String save(Model model,User user,HttpServletRequest request){
		
			try {
				String[] roles = request.getParameterValues("roles");
				String uuid = UUID.randomUUID().toString().replace("-", "");
				user.setId(uuid);
				
				user.setCreatetime(DateUtil.formatDateTime(new Date()));
				
				userService.add(user);
				
				if(roles!=null&&roles.length>0)
				{
					
					for(String role_id:roles)
					{
						UserRole ur =new UserRole();
						
						ur.setRole_id(role_id);
						
						ur.setUser_id(uuid);
						userService.saveUserRole(ur);
						
					}
					
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "redirect:/user/getList.do";
	}
	private void saveUserRole() {
		// TODO Auto-generated method stub
		
	}



	@ResponseBody
	@RequestMapping("/checkLoginByName")
	public String checkLoginByName(String loginname)
	{
		
		String isRegin="true";
	User user=	userService.getUserByLoginName(loginname);
	
	
	if(user!=null)isRegin="用户已存在！";
	
	
	return isRegin;
		
	}

	
}
