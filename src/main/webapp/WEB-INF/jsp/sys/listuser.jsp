<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script src="<%=basePath%>js/user/user.js"
	type="text/javascript"></script>
</head>

<style type="text/css">

#table th, #table td {vertical-align:middle;}

</style>

<script type="text/javascript">

function addUI(){
	
	location.href="${ctx}/user/addUI.do";
	
}

</script>

<body>



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

  <button type="button"  class="btn btn-default" onclick="addUI()">
  <span class="glyphicon glyphicon-remove-sign" ></span> 
  增加</button> 
  <button type="button" class="btn btn-default">
    <span class=" glyphicon glyphicon-circle-arrow-down"></span> 
  
  提交</button> 
  <button type="button" class="btn btn-default">
   <span class="glyphicon glyphicon-ok-circle"></span> 
 
  下载</button> 
  
  
  </div>
	







	<form class="form-inline" action="<%=basePath%>user/getList.do"
		style="background-color:#eeeeee;padding: 15px 15px;margin-top: 50px;" method="post">

		<div class="form-group">
			<label for="exampleInputName2">登录名：</label>
			 <input type="text" class="form-control" name="loginname" id="exampleInputName2" placeholder="" value="${user.loginname }">
		</div>
		
		<div class="form-group">
			<label for="exampleInputName2">真实姓名：</label> <input type="text"
				class="form-control" id="exampleInputName2" name="username" placeholder="" value="${user.username }">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">手机号：</label> <input type="email"
				class="form-control" id="exampleInputEmail2" name="phone" value="${user.phone }"
				placeholder="">
		</div>
		<div class="form-group">
		<button type="submit" class="btn btn-primary">查询</button>
		</div>
	</form>
	
	

	
	
	



	<div class="table-responsive">

		<table id="table" class="table table-bordered  table-striped table-hover"
			style="font-size: 12px;">
			<thead>
				<tr>
					<th>登录名</th>
					<th>真实姓名</th>
					<th>手机号</th>
					<th>注册时间</th>
					
					<th>角色</th>
					
					
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${pageview.records }" var="m">
					<tr>
						<td>${m.loginname }</td>
						<td>${m.username }</td>
						<td>${m.phone }</td>
						<td>${m.createtime }</td>
						
						<td>${m.rolename }</td>
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



