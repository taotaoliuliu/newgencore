<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath%>" />
		<title>紫荆新锐内部管理平台</title>
		<link href="css/validate.css" rel="stylesheet" type="text/css" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />

	</head>
	
	 <script type="text/javascript">
	
	if(window.parent != window){
			
	window.parent.location.href="<%=basePath%>"+"index.jsp";
			
		}
	
	</script>
	<body>
		<div id="man_zone">
			<div class="navbar">
				系统提示
			</div>		
			<div class="toolbar">
	
			</div>
		
			<div width="100%" align="center" style="position:relative; top:40%">
				<span>对不起，您的访问已经超时，请重新登录。</span>
				<input type="button" value="确定" class="button_60" onMouseOver="this.className='button_60_over'" onMouseOut="this.className='button_60'" onclick="dologin()"/>				
			</div>
		</div>	
	</body>
	<script language="javascript">
	function dologin()
	{
		window.parent.window.location.href="<%=basePath%>"+"user/login.do"
	}
	</script>
</html>