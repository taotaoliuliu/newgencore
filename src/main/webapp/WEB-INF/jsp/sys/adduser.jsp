<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript">


$(function(){


 $("#saveuser").validate(
   {
    rules: {
    loginname: {required:true,
     remote:{                                          //验证用户名是否存在
               type:"POST",
               url:"${ctx}/user/checkLoginByName.do",             //servlet
               data:{
                 loginname:function(){return $("#loginname").val();}
               } 
              } 
    
    },
     username: {required:true},
         password: {required:true,minlength:6},
    passwdconfirm: {required:true,equalTo:"#password"},
    
    
    },
   messages: {
   loginname: {required:"登录名不能为空！",remote:jQuery.format("用户名已存！")},
   username:{required:"密码不能为空！"},
   password: {required:"密码不能为空！",minlength:jQuery.format("密码位数必须大于等于6个字符！")},
   
   passwdconfirm: {required:"确认密码不能为空！",equalTo:"确认密码和密码不一致！"},
   
   },
   submitHandler: function(form){
					
				
					form.submit();
				}
   
   
   })





})

</script>

</head>

<body>
 


	<form id="saveuser" class="form-horizontal" role="form" action="${ctx }/user/save.do" method="post">
		<input type="hidden" name="id" value="${role.id }">
		
		<div class="form-group">
			<label for="loginname" class="col-sm-2 control-label">登录名</label>
			<div class="col-sm-3">
				<input type="text" id="loginname" class="form-control" name="loginname"
					placeholder="请输入名字" value="${user.loginname }">

			</div>
			
			<div class="col-sm-1" style="margin-left: -12px;padding-left: -10px;padding-top: 10px;">
      <font color="red">*</font>
    </div>
			
		</div>
		
		
		<div class="form-group">
			<label  class="col-sm-2 control-label">真实姓名</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="username" name="username"
					placeholder="请输入名字" value="${user.username }">
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">手机号</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="phone" name="phone"
					placeholder="请输入名字" value="${user.phone }"> 
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="password" name="password"
					placeholder="请输入密码" value="${user.password }"> 
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">确认密码</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="passwdconfirm" name="passwdconfirm"
					placeholder="请输入确认密码" value="${user.passwdconfirm }"> 
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">角色</label>
			<div class="col-sm-3">
				<c:forEach items="${listRole }" var="m">
				${m.name }<input type="checkbox" name="roles" value="${m.id }"> 
				
				</c:forEach>
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
