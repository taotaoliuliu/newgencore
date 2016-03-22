package com.newgen.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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



@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	
	
	
	
	
	
	@RequestMapping("login")
	public String login(User info,Model model,HttpServletRequest request) {
		
		
		
		
		String username = info.getLoginname();
		
		String password = info.getPassword();
		
		
		// 想要得到 SecurityUtils.getSubject()　的对象．．访问地址必须跟ｓｈｉｒｏ的拦截地址内．不然后会报空指针
		Subject sub = SecurityUtils.getSubject();
		// 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
		// 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
		// 当以上认证成功后会向下执行,认证失败会抛出异常
		
		password = UninewsTools.encryptPassword(password);

		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		
		

		
		
		System.out.println("####");
		
		
		
		
		
		
		
		
		
		
		try {
			sub.login(token);
		} catch (LockedAccountException lae) {
			token.clear();
			request.setAttribute("error", "用户已经被锁定不能登录，请与管理员联系！");
			return "sys/login";
		} catch (AuthenticationException e) {
			token.clear();
			request.setAttribute("error", "用户或密码不正确！");
			return "sys/login";
		}
		
		
			
	

		return "redirect:/user/index";
	

		
/*	User user=	userService.getUserByNameAndPassword(username,password);
	if(user!=null)
	{
		
		
		request.getSession().setAttribute("user", user);
		
		String loginname = user.getLoginname();
		
		List<Menu> listmenu=new ArrayList<Menu>();
		if(loginname.equals("admin"))
		{
			listmenu=menuService.queryAll(null);
			
		}
		else {
			
			listmenu= menuService.getListByUser(user);
		}

		
	 
		
		
		
		
		model.addAttribute("menuList", listmenu);
		return "sys/sysIndex";

	}
	else {
		return "sys/login";

		
	}*/
	
		
		
	}
	
	@RequestMapping("index")
	public String index(Model model,HttpServletRequest request)
	{
		
		User user = (User) request.getSession().getAttribute("user");
		
//	List<Menu> listmenu=(List<Menu>) CacheUtils.get("userCache", "user_menu_"+user.getId());
	List<Menu> listmenu=null;
		
		String username = user.getLoginname();

		//List<Menu> listmenu=new ArrayList<Menu>();
		if(username.equals("admin"))
		{
			if(listmenu==null||listmenu.size()<=0)
			{
				listmenu=menuService.getUrlWithNoButton(null);
				
				//CacheUtils.put("userCache", "user_menu_"+user.getId(), listmenu);


			}
		
			
		}
		else {
			
			
			if(listmenu==null||listmenu.size()<=0)
			{
				listmenu= menuService.getListByUserWithNoButton(user);

				//CacheUtils.put("userCache", "user_menu_"+user.getId(), listmenu);

			}
			
		}

		
		model.addAttribute("menuList", listmenu);
		return "sys/sysIndex";

	}
	@RequestMapping("logout")
	public String logout(){
		
		
		
		return "sys/login";

	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/getList")
	public String getList(HttpServletRequest request,User user,String pageNow,String pageSize,Model model){
		
		
		
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
		
		
		
		
		
		model.addAttribute("pageview",pageview);
		model.addAttribute("user", user);
		
		
		return "sys/listuser";
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
