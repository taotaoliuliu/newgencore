package com.newgen.core.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.Role;
import com.newgen.core.bean.RoleMenu;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.RoleService;


@RequestMapping("/role")
@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping("/getList")
	public String getList(Model model)
	{
		

		
		List<Role> queryAll = roleService.queryAll(null);
		
		
		model.addAttribute("list", queryAll);

		
		
		return "sys/rolelist";
	}
	
	@RequestMapping("/addUI")
	public String addUI(Model model)
	{
		List<Menu> queryAll = menuService.queryAll(null);
		//List<Resources> listAll=	powerService.getAll();
		model.addAttribute("menuList", queryAll);
		
		
		
		return "sys/addrole";

	}
	
	@RequestMapping("/save")
	public String save(Model model,HttpServletRequest request,Role role)
	{
		String menus = request.getParameter("menus");
		
		try {
			String role_id = UUID.randomUUID().toString().replace("-", "");
			
			role.setId(role_id);
				
			roleService.add(role);
			
			
			if(!StringUtils.isBlank(menus))
			{
				
				String[] menuss = menus.split(",");
				
				for(String menu_id:menuss)
				{
					
					RoleMenu rm = new RoleMenu();
					
					rm.setMenu_id(menu_id);
					
					rm.setRole_id(role_id);
					
					roleService.saveRoleMenu(rm);
				}
				
			}
			
			model.addAttribute("msg", "创建成功！");
			
		} catch (Exception e) {
			model.addAttribute("msg", "创建失败！");
			e.printStackTrace();
		}
		
		
		
		
		return "redirect:/role/getList.do";

	}
	
	
	@RequestMapping("/updateUI")
	public String updateUI(Model model,Role role)
	{
		
		
		model.addAttribute("saveorupdate", "01");
		
		
		List<Menu> queryAll = menuService.queryAll(null);
		//List<Resources> listAll=	powerService.getAll();
		model.addAttribute("menuList", queryAll);
		
		Role findrole = roleService.getById(role.getId());
		
		model.addAttribute("role", findrole);
		
	List<RoleMenu> list=	roleService.getRoleMenuByRoleID(role.getId());
	
	if(list!=null&&list.size()>0)
	{
		
		String menus="";
		for(RoleMenu rm:list)
		{
			
			menus+=rm.getMenu_id()+",";
		}
		findrole.setMenus(menus);

	}
	
		
		
		
		
		
		
		return "sys/addrole";

	}
	
	
	@RequestMapping("/update")
	public String update(Model model,Role role)
	{
		
		try {
			roleService.update(role);
			
			roleService.deleteRoleMenuByRoleID(role.getId());
			
			
			String menus = role.getMenus();
			
			if(!StringUtils.isBlank(menus))
			{
				String[] split = menus.split(",");
				for(String menu_id:split)
				{
					RoleMenu rm = new RoleMenu();
					
					rm.setMenu_id(menu_id);
					rm.setRole_id(role.getId());
					
					roleService.saveRoleMenu(rm);

					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "redirect:/role/getList.do";

	}

}
