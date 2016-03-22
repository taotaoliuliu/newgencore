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
    
    <script type="text/javascript" src="<%=basePath%>resources/jquery-jbox/2.3/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/jquery-jbox/2.3/jquery.jBox-2.3.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/jquery-jbox/2.3/i18n/jquery.jBox-zh-CN.js"></script> 
       <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/jquery-jbox/2.3/Skins2/Green/jbox.css" />
	<script type="text/javascript">
	
	
	$(function(){
	
	alert("#####");
	})
	
	
	function openSome()
	{
	
	
	
	var data;
	$.jBox("iframe:jsp/11.jsp", {
    title: "百度一下",
    width: 800,
    height: 350,
    buttons: { '上一步': -1, '提交': 1, '取消': 0 },
    submit:function(v, h, f){
    if(v==1)
    {
    var iframeName = h.children(0).attr("name");
                            var iframeHtml = window.frames[iframeName];               //获取子窗口的句柄
                            iframeHtml.aa();
                            
                            
                            return false;
 
 
    }
    
    
    }
});
	
	
	
	
	}
	
	
	
	function demo01() {
            jBox.tip("Hello jBox");
            //jBox.tip("提示关闭后设置输入框为焦点", 'success', { focusId: 'name' });
            //jBox.tip("提示关闭后设置输入框为焦点", 'info', { top: '30%', width: 300, focusId: 'name', closed: function () { alert('before focus input...'); } });
        }
        
        
        	function demo02() {
        	
        	$.jBox("get:11.jsp");
        }
	
		
		
		// 恢复提示框显示
function resetTip(){
	jBox.tip.mess = null;
}

// 关闭提示框
function closeTip(){
	jBox.closeTip();
}


//显示提示框
function showTip(mess, type, timeout, lazytime){
	resetTip();
	setTimeout(function(){
		top.$.jBox.tip(mess, (type == undefined || type == '' ? 'info' : type), {opacity:0, 
			timeout:  timeout == undefined ? 5000 : timeout});
	}, lazytime == undefined ? 500 : lazytime);
}



// 显示加载框
function loading(mess){
	if (mess == undefined || mess == ""){
		mess = "正在提交，请稍等...";
	}
	resetTip();
	top.$.jBox.tip(mess,'loading',{opacity:0});
}



// 确认对话框
function confirmx(mess, href, closed){
	top.$.jBox.confirm(mess,'系统提示',function(v,h,f){
		if(v=='ok'){
			if (typeof href == 'function') {
				href();
			}else{
				resetTip(); //loading();
				location = href;
			}
		}
	},{buttonsFocus:1, closed:function(){
		if (typeof closed == 'function') {
			closed();
		}
	}});
	top.$('.jbox-body .jbox-icon').css('top','55px');
	return false;
}


// 提示输入对话框
function promptx(title, lable, href, closed){
	top.$.jBox("<div class='form-search' style='padding:20px;text-align:center;'>" + lable + "：<input type='text' id='txt' name='txt'/></div>", {
			title: title, submit: function (v, h, f){
	    if (f.txt == '') {
	        top.$.jBox.tip("请输入" + lable + "。", 'error');
	        return false;
	    }
		if (typeof href == 'function') {
			href();
		}else{
			resetTip(); //loading();
			location = href + encodeURIComponent(f.txt);
		}
	},closed:function(){
		if (typeof closed == 'function') {
			closed();
		}
	}});
	return false;
}

		
	
	</script>
    
  </head>
  
  <body>
  
  
		<button type="button" class="btn btn-primary" onclick="demo01()">查询</button>
		<button type="button" class="btn btn-primary" onclick="openSome()">openJsp</button>

  
  		<button type="button" class="btn btn-primary" onclick="demo02()">查询</button>
  		<button type="button" class="btn btn-primary" onclick="demo02()">查询</button>
  		<button type="button" class="btn btn-primary" onclick="resetTip()">resetTip</button>
  		<button type="button" class="btn btn-primary" onclick="closeTip()">closeTip</button>
  		<button type="button" class="btn btn-primary" onclick="showTip('lsllllsls')">showTip</button>
  		<button type="button" class="btn btn-primary" onclick="loading('正在提交，请稍等...')">loading</button>
  		<button type="button" class="btn btn-primary" onclick="confirmx('正在提交，请稍等...')">confirmx</button>
  		<button type="button" class="btn btn-primary" onclick="promptx('正在提交，请稍等...')">promptx</button>
  
  
  
  
  
  
  
   
  </body>
</html>
