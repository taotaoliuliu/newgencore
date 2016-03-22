<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tanchu.jsp' starting page</title>
    
    <script type="text/javascript" src="resources/jquery-jbox/2.3/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="resources/jquery-jbox/2.3/jquery.jBox-2.3.js"></script>
       <link rel="stylesheet" type="text/css" href="resources/jquery-jbox/2.3/Skins/Default/jBox.css" />
	<script type="text/javascript">
	
	
function aa()
{
alert("!!!!");

alert("保存成功");
                            window.parent.location.reload();	                                    //调用父窗体方法，当关闭子窗体刷新父窗体
                            window.parent.window.jBox.close();            //关闭子窗体
}
	
	
	
	</script>
    
  </head>
  
  <body>
 

  
  
  
  
  
  
  
  
   
  </body>
</html>
