package com.newgen.core.shiro;

import java.util.List;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.core.service.MenuService;
import com.newgen.core.service.UserService;
import com.newgen.yctg.utils.StringTools;
import com.newgen.yctg.utils.UninewsTools;

/**
 * 自定义Realm,进行数据源配置
 * @author lsl 2014-12-25
 * @Email: m@163.com
 * @version 3.0v
 */
public class MyRealm extends AuthorizingRealm {



	@Inject
	private MenuService menuService;

	@Inject
	private UserService userService;
	



 //只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		String loginName = SecurityUtils.getSubject().getPrincipal().toString();
		if (loginName != null) {
			User user = (User) SecurityUtils.getSubject().getSession()
					.getAttribute("user");
			List<Menu> rs = menuService.getListByUser(user);
			
			
			if(user.getLoginname().equals("admin")){
				
				
				rs=menuService.queryAll(null);
			}
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			//info.addRole("default");
			// 用户的角色集合
			// info.setRoles(user.getRolesName());
			// 用户的角色对应的所有权限，如果只使用角色定义访问权限
			for (Menu resources : rs) {
				
				String powerkey = resources.getPowerkey();
				
				if(!StringTools.isNullOrEmpty(powerkey))
				{
					info.addStringPermission(resources.getPowerkey());

				}
			}
				System.out.println(info);
			return info;
		}
		return null;
	}

	/**
	 * 认证回调函数,登录时调用
	 * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
	 * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
	 * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
	 * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
	 * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
	 * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
	 * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String loginname = (String) token.getPrincipal();

		User account = userService.getUserByLoginName(loginname);

		if (account != null) {
			if ("0".equals(account.getLocked())) {
				throw new LockedAccountException(); // 帐号锁定
			}
			//从数据库查询出来的账号名和密码,与用户输入的账号和密码对比
			//当用户执行登录时,在方法处理上要实现user.login(token);
			//然后会自动进入这个类进行认证
			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
			
			//System.out.println(ByteSource.Util.bytes(account.getCredentialsSalt()));
			
			System.out.println(getName());
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					account.getLoginname(), // 用户名
					account.getPassword(), // 密码
				
					getName() // realm name
			);
			// 当验证都通过后，把用户信息放在session里
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("user", account);
			//session.setAttribute("userSessionId", account.getId());
			return authenticationInfo;
		} else {
			throw new UnknownAccountException();// 没找到帐号
		}

	}

}