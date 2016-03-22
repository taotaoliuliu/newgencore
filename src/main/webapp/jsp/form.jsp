<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<script src="<%=basePath %>resources/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>

<link
	href="<%=basePath%>resources/bootstrap/3.3.5/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<script src="<%=basePath%>resources/bootstrap/3.3.5/js/bootstrap.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
		href="<%=basePath %>css/core.css" />
		


</head>

<body>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">名字</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="firstname"
					placeholder="请输入名字">
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">姓</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="lastname"
					placeholder="请输入姓">
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> 请记住我 </label>
				</div>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
<div style="background-color:#F5F5F5; width: 100%;height: 80px;padding-top: 20px;">  

	<div class="col-sm-offset-2 col-sm-10">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			
			<input id="btnCancel" class="btn" style="background-color: #FFFFFF" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</div>

	</form>
</body>
</html>
