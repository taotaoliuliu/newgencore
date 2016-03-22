<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">

#table th, #table td {vertical-align:middle;}

</style>

<script src="<%=basePath%>js/user/user.js"
	type="text/javascript"></script>
</head>


<script type="text/javascript">


$(function(){


$(".btndelete").click(function(){


var articleid=$(this).attr("articleid");


top.$.jBox.confirm('确定要删除吗？','系统提示',function(v,h,f){
		if(v=='ok'){
			
					top.$.jBox.tip.mess = null;

location.href="${ctx}/cms/delete.do?articleid="+articleid;
		
		}
	},{buttonsFocus:1, closed:function(){
		
	}});




});


$(".btnupdate").click(function(){

var articleid=$(this).attr("articleid");

location.href="${ctx}/cms/updateUI.do?articleid="+articleid;



});


//$("#checkall").attr("checked");

//1.6之后变了
$("#checkall").click(function(){



var isChecked= $("#checkall").is(':checked');   

	$("input[name='checkbox']").prop("checked",isChecked);

})


})

function addUI(){
	
	location.href="${ctx}/user/addUI.do";
	
}

function show(){

alert($("#messageBox"));

$("#messageBox").css('display','block')
} 

function del()
{

$(".checkbox:checked").each(function(){

 var aa =$(this).val();
 
 alert(aa);


})





}

</script>

<body>



	<ul class="nav nav-tabs">
		<li class="active"><a
			href="${ctx}/cms/article/?category.id=">文章列表</a>
		</li>
		<li><a
			href="${ctx}/cms/addArticleUI.do">文章添加</a>
		</li>
	</ul>
<br>




<div style="margin-top: 50px;margin-left: 5px;position: fixed;z-index: 1000;top: 0px;border-bottom: 3px solid #0FA6DB;
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
  
    <button type="button" class="btn btn-default" onclick="del()">
   <span class="glyphicon glyphicon-ok-circle"></span> 
 
  删除</button> 
  
  
  </div>
  

  
<c:if test="${not empty infocontent}">	

<div id="messageBox" class="alert alert-${ctype }" style="margin-top: 30px;display: none;"><button data-dismiss="alert" class="close">×</button>${infocontent }</div> 
	<script type="text/javascript">
	
	
top.$.jBox.tip.mess=null;
	
	if(!top.$.jBox.tip.mess){top.$.jBox.tip.mess=1;top.$.jBox.tip("${infocontent}","${ctype}",{opacity:0});$("#messageBox").show();}</script>

</c:if>



	<form class="form-inline" action="<%=basePath%>user/getList.do" id="form"
		style="background-color:#eeeeee;padding: 15px 15px;margin-top: 30px;" method="post">

		<div class="form-group">
			<label for="exampleInputName2">标题：</label>
			 <input type="text" class="form-control" name="loginname" id="exampleInputName2" placeholder="" value="">
		</div>
		
		<div class="form-group">
			<label for="exampleInputName2">创建时间：</label> <input type="text"
				class="form-control" id="exampleInputName2" name="username" placeholder="" value="">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">作者：</label> <input type="email"
				class="form-control" id="exampleInputEmail2" name="phone" value=""
				placeholder="">
		</div>
		<div class="form-group">
		<button type="submit" class="btn btn-primary">查询</button>
		</div>
	</form>
	
	

	
	
	



	<div class="table-responsive">

		<table id="table" class="table table-bordered  table-striped table-hover" style="font-size: 12px;">
			<thead>
				<tr>
				<th><input type="checkbox"  id="checkall" ></th>
					<th>作者</th>
					<th>栏目</th>
					<th>标题</th>
					<th>创建时间</th>
					<th>关键字</th>
					
					
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${pageview.records }" var="m">
					<tr>
					<td><input type="checkbox" class="checkbox" name="checkbox" value="${m.id }"> </td>
						<td>${m.authorname }</td>
						<td>${m.category.name }</td>
						<td style="vertical-align: middle;">${m.title }aaa</td>
						<td>${m.createtime }</td>
						<td>${m.keyword }</td>
						<td>
						<shiro:hasPermission name="cms:update"> 
						
						<button type="button" class="btn btn-primary btndelete"  articleid="${m.id }">删除</button>
						<button type="button" class="btn btn-primary btnupdate"  articleid="${m.id }">修改</button>
						
						
						</shiro:hasPermission>
</td>
					</tr>


				</c:forEach>
				
				
				aaaaa
				<#list pageview.records as m>
				<tr>
				aaaaa
				<td>${m.title}</td>
				
				</tr>
				
				
				</#list>
				
				
				

			</tbody>
		</table>
	</div>
			
		
	<%@ include file="/WEB-INF/jsp/common/page.jsp" %>






</body>
</html>



