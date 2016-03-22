<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

<link
	href="<%=basePath%>resources/bootstrap/3.3.5/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<script src="<%=basePath%>resources/bootstrap/3.3.5/js/bootstrap.min.js"
	type="text/javascript"></script>



</head>

<body style="font-size: 12px;">



<%-- 	<ul class="nav nav-tabs">
		<li class="active"><a
			href="${ctx}/cms/article/?category.id=${article.category.id}">文章列表</a>
		</li>
		<li><a
			href="<c:url value='/cms/article/form?id=${article.id}&category.id=${article.category.id}'><c:param name='category.name' value='${article.category.name}'/></c:url>">文章添加</a>
		</li>
	</ul>
 --%>




<div style="margin-top: 0px;margin-left: 5px;position: fixed;z-index: 1000;top: 0px;border-bottom: 3px solid #0FA6DB;
width: 100%;background: #FFF;">

  <button type="button"  class="btn btn-default">
  <span class="glyphicon glyphicon-remove-sign"></span> 
  删除</button> 
  <button type="button" class="btn btn-default">
    <span class=" glyphicon glyphicon-circle-arrow-down"></span> 
  
  提交</button> 
  <button type="button" class="btn btn-default">
   <span class="glyphicon glyphicon-ok-circle"></span> 
 
  下载</button> 
  
  
  </div>
	







	<form class="form-inline" action="<%=basePath%>user/getPageUser.do"
		style="background-color:#eeeeee;padding: 15px 15px;margin-top: 50px;" method="post">

		<div class="form-group">
			<label for="exampleInputName2">姓名：</label> <input type="text"
				class="form-control" id="exampleInputName2" placeholder="Jane Doe">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">邮件：</label> <input type="email"
				class="form-control" id="exampleInputEmail2"
				placeholder="jane.doe@example.com">
		</div>
		<button type="submit" class="btn btn-primary">查询</button>
	</form>
	
	

	
	
	



	<div class="table-responsive">

		<table class="table table-bordered  table-striped table-hover"
			style="font-size: 12px;">
			<thead>
				<tr>
					<th>登录名</th>
					<th>真实姓名</th>
					<th>身份证号</th>
					<th>省份</th>
					<th>市级</th>
					<th>县/区</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${pageview.records }" var="m">
					<tr>
						<td>${m.name_Login }</td>
						<td>${m.name_real }</td>
						<td>${m.idcard }</td>
						<td>${m.province }</td>
						<td>${m.city }</td>
						<td>${m.county }</td>

						<td><button type="button" class="btn btn-primary">删除</button>
						</td>

					</tr>


				</c:forEach>

			</tbody>
		</table>
	</div>
			
		
	<%@ include file="/WEB-INF/jsp/common/page.jsp" %>






</body>
</html>



