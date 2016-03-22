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

<script src="<%=basePath %>resources/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>

<link
	href="<%=basePath%>resources/bootstrap/3.3.5/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<script src="<%=basePath%>resources/bootstrap/3.3.5/js/bootstrap.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
		href="<%=basePath %>css/core.css" />
		
		
		<link href="<%=basePath %>resources/jquery-ztree/3.5.12/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=basePath %>resources/jquery-ztree/3.5.12/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
		
		<link
	href="${pageContext.request.contextPath}/resources/jquery-validation/1.11.0/jquery.validate.min.css"
	type="text/css" rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/jquery-validation/1.11.0/jquery.validate.min.js"
	type="text/javascript"></script>
		
<script type="text/javascript">


$(function(){



//validation

 $("#saverole").validate(
   {
    rules: {
    name: {required:true}
    
    },
   messages: {
   name: {required:"角色名称不能为空！"},
   },
   submitHandler: function(form){
					var ids = [],
					 nodes = tree.getCheckedNodes(true);
					for(var i=0; i<nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					$("#menus").val(ids);
				
					form.submit();
				}
   
   
   })




















//ztree
	var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
					data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
						tree.checkNode(node, !node.checked, true, true);
						return false;
					}}};

			// 用户-菜单
			var zNodes=[
					{id:0, pId:0, name:"权限列表"},
			
					<c:forEach items="${menuList}" var="menu">
					{id:"${menu.powerid}", pId:"${menu.fatherid}", name:"${menu.powername}"},
		            </c:forEach>];
			// 初始化树结构
			var tree = $.fn.zTree.init($("#menuTree"), setting, zNodes);
			// 不选择父节点
			tree.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
			// 默认选择节点
			var ids = "${role.menus}".split(",");
			if(ids!="")
			{
			
			for(var i=0; i<ids.length; i++) {
			
				var node = tree.getNodeByParam("id", ids[i]);
			
				try{tree.checkNode(node, true, false);}catch(e){}
			}
			}
			// 默认展开全部节点
			tree.expandAll(true);




})

</script>

</head>

<body>


	<form id="saverole" class="form-horizontal" role="form" action="role/<c:if test="${saveorupdate=='01' }">update.do</c:if><c:if test="${saveorupdate!='01' }">update.do</c:if>" method="post">
		<input type="hidden" name="id" value="${role.id }">
		
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">角色名称</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="name" name="name"
					placeholder="请输入名字" value="${role.name }">
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">权限分配</label>
			<div class="col-sm-3">
		<div id="menuTree" class="ztree" style="margin-top:3px;float:left;"></div>
		
		<input type="hidden" name="menus" id="menus">
				
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
