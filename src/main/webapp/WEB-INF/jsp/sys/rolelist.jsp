<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>


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
	
	
	<script src="<%=basePath%>js/role/list.js"
	type="text/javascript"></script>
	
	<script type="text/javascript">
	
	function addUI(base)
{

	location.href=base+"/role/addUI.do";

}

function updateUI(roleid){


location.href="${ctx}/role/updateUI.do?id="+roleid;
}
	
	</script>



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

  <button type="button"  class="btn btn-default" onclick="addUI('<%=basePath%>')">
  <span class="glyphicon glyphicon-remove-sign"></span> 
  新增</button> 

  
  
  </div>
  
  	<div id="messageBox" class="alert hide"><button data-dismiss="alert" class="close">×</button>${msg}</div> 
  



	<div class="table-responsive" style="margin-top: 80px;">

		<table class="table table-bordered  table-striped table-hover"
			style="font-size: 12px;">
			<thead>
				<tr>
					<th>角色名称</th>
					
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list }" var="m">
					<tr>
						<td>${m.name }</td>
					<td><button type="button" class="btn btn-primary">分配</button>
					
						<button type="button" class="btn btn-primary" onclick="updateUI('${m.id}')">修改</button>
					
						

						<button type="button" class="btn btn-primary">删除</button>
						</td>

					</tr>


				</c:forEach>

			</tbody>
		</table>
	</div>
			
		






</body>
</html>



