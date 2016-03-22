package com.newgen.core.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.newgen.core.bean.User;




public class SessionInterceptor extends HandlerInterceptorAdapter 
{
	
    private static List<String> excludedUrls=new ArrayList<String>();
    
   static{
	   
	   excludedUrls.add("/faceImage_p");
	   excludedUrls.add("/upload");
		excludedUrls.add("/load");
		excludedUrls.add("/login.do");
		excludedUrls.add("/voteupload");
		excludedUrls.add("/out");
		excludedUrls.add("/resources");
		excludedUrls.add("/css");
		excludedUrls.add("/js");
   }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
		
		  String requestUri = request.getRequestURI();
	        for (String url : excludedUrls) {
	        	
	            if (requestUri.contains(url)) {
	            	
	            	System.out.println("dwdwdwdw");
	                return true;
	            }
	        }


		
		HttpSession session = request.getSession();
		
User user	=(User)session.getAttribute("user");
	
	
	if(user==null)
	{
		
		 throw new AuthorizationException();

		
	}
	else {
		
		return true;

		
	}
		
		
		
		
		
		
	}
    
    /**
     * 注释内容
     */

/*	private String errMess;//错误提示
    public String getErrMess() {
		return errMess;
	}

	public void setErrMess(String errMess) {
		this.errMess = errMess;
	}

	private static final long serialVersionUID = -7679662357952998028L;
    private Log log = LogFactory.getLog(AuthorityInterceptor.class);
    private static final String TIMEOUT = "timeout";
    //拦截Action处理的拦截方法   
    public String intercept(ActionInvocation invocation) throws Exception
    {
        // 取得请求相关的ActionContext实例   
        ActionContext ctx = invocation.getInvocationContext();
        log.info("进入拦截器	");
        Map<String, Object> session = ctx.getSession();
        //取出名为operator的session属性   
        Admin operator = (Admin) session.get("user");
        //如果没有登陆，返回重新登陆   
        if (operator == null)
        {
        	errMess="登录超时，请重新登录";
        	log.info("登录超时，请重新登录");
            return TIMEOUT;
        }

        return invocation.invoke();
    }*/
	
	
	
	
	
	
}
