<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<%@ page contentType="text/html;charset=UTF-8"%><meta
	http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="author" content="http://jeesite.com/" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10" />
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store">
<script src="<%=basePath %>resources/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
<link
	href="<%=basePath %>resources/bootstrap/2.3.1/css_cerulean/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<script src="<%=basePath %>resources/bootstrap/2.3.1/js/bootstrap.min.js"
	type="text/javascript"></script>
<link href="<%=basePath %>resources/bootstrap/2.3.1/awesome/font-awesome.min.css"
	type="text/css" rel="stylesheet" />
<script src="<%=basePath %>resources/bootstrap/bsie/js/bootstrap-ie.min.js" type="text/javascript"></script>
<link href="<%=basePath %>resources/jquery-select2/3.4/select2.min.css"
	rel="stylesheet" />
<script src="<%=basePath %>resources/jquery-select2/3.4/select2.min.js"
	type="text/javascript"></script>
<link
	href="<%=basePath %>}jquery-validation/1.11.0/jquery.validate.min.css"
	type="text/css" rel="stylesheet" />
<script
	src="<%=basePath %>jquery-validation/1.11.0/jquery.validate.min.js"
	type="text/javascript"></script>
<link href="<%=basePath %>resources/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css"
	rel="stylesheet" />
<script src="<%=basePath %>resources/jquery-jbox/2.3/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="<%=basePath %>My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="<%=basePath %>common/mustache.min.js" type="text/javascript"></script>
<link href="<%=basePath %>resources/common/jeesite.css" type="text/css"
	rel="stylesheet" />
<script src="<%=basePath %>resources/common/jeesite.min.js" type="text/javascript"></script>
	<link rel="stylesheet"
		href="<%=basePath %>resources/jerichotab/css/jquery.jerichotab.css" />
	<script type="text/javascript"
		src="<%=basePath %>resources/jerichotab/js/jquery.jerichotab.js"></script>
		
		<link rel="stylesheet"
		href="<%=basePath %>css/core.css" />
		
		
		
<style type="text/css">
		#main {padding:0;margin:0;} #main .container-fluid{padding:0 4px 0 6px;}
		#header {margin:0 0 8px;position:static;} #header li {font-size:14px;_font-size:12px;}
		#header .brand {font-family:Helvetica, Georgia, Arial, sans-serif, 黑体;font-size:26px;padding-left:33px;}
		#footer {margin:8px 0 0 0;padding:3px 0 0 0;font-size:11px;text-align:center;border-top:2px solid #0663A2;}
		#footer, #footer a {color:#999;} #left{overflow-x:hidden;overflow-y:auto;} #left .collapse{position:static;}
		#userControl>li>a{/*color:#fff;*/text-shadow:none;} #userControl>li>a:hover, #user #userControl>li.open>a{background:transparent;}
	</style>
<script type="text/javascript">

		$(document).ready(function() {		
	
			$.fn.initJerichoTab({
                renderTo: '#right', uniqueId: 'jerichotab',
                contentCss: { 'height': $('#right').height() - tabTitleHeight,'width':'100%' },
                tabs: [], loadOnce: true, tabWidth: 110, titleHeight: tabTitleHeight
            });
			// 绑定菜单单击事件
			$("#menu a.menu").click(function(){
			
						
				// 一级菜单焦点
				$("#menu li.menu").removeClass("active");
				$(this).parent().addClass("active");
				
				
				// 左侧区域隐藏
				if ($(this).attr("target") == "mainFrame"){
					$("#left,#openClose").hide();
					wSizeWidth();
					// <c:if test="${tabmode eq '1'}"> 隐藏页签
					$(".jericho_tab").hide();
					$("#mainFrame").show();//</c:if>
					return true;
				}
				// 左侧区域显示
				$("#left,#openClose").show();
				if(!$("#openClose").hasClass("close")){
					$("#openClose").click();
				}
				// 显示二级菜单
				var menuId = "#menu-" + $(this).attr("data-id");
				

				
				if ($(menuId).length > 0){
				
				
				// 链接去掉虚框
						$(menuId + " a").bind("focus",function() {
							if(this.blur) {this.blur()};
						});
				
				
				// 二级标题
						$(menuId + " .accordion-heading a").click(function(){
							$(menuId + " .accordion-toggle i").removeClass('icon-chevron-down').addClass('icon-chevron-right');
							if(!$($(this).attr('data-href')).hasClass('in')){
								$(this).children("i").removeClass('icon-chevron-right').addClass('icon-chevron-down');
							}
						});
						// 二级内容
						$(menuId + " .accordion-body a").click(function(){
							$(menuId + " li").removeClass("active");
							$(menuId + " li i").removeClass("icon-white");
							$(this).parent().addClass("active");
							$(this).children("i").addClass("icon-white");
						});
				
				
				
				
					$("#left .accordion").hide();
					$(menuId).show();
					// 初始化点击第一个二级菜单
					if (!$(menuId + " .accordion-body:first").hasClass('in')){
						$(menuId + " .accordion-heading:first a").click();
					}
					if (!$(menuId + " .accordion-body li:first ul:first").is(":visible")){
						$(menuId + " .accordion-body a:first i").click();
					}
					
					$(menuId + " .accordion-inner a").click(function(){
						
						
							var href = $(this).attr("data-href");
							
					
							
							
							if($(href).length > 0){
							
							$(href).toggle();
								 	$(href).toggle().parent().toggle();
							
								return false;
							}
							
						
							return addTab($(this));
						});
						
						//初始化三级菜单
						//$(menuId + " .accordion-body li:first li:first a:first i").click();
						
						//初始化二级菜单
				//$(menuId + " .accordion-body li:first a:first i").click();
						
						
				}else{
				
					var pid=	$(this).attr("data-id");
					// 获取二级菜单数据
					$.get("<%=basePath %>resources/getResources.do?parentId="+pid, function(data){
		
						if (data.indexOf("id=\"loginForm\"") != -1){
							alert('未登录或登录超时。请重新登录，谢谢！');
							top.location = "${ctx}";
							return false;
						}
						$("#left .accordion").hide();
						
					$("#left").append(data);
						// 链接去掉虚框
						$(menuId + " a").bind("focus",function() {
							if(this.blur) {this.blur()};
						});
						// 二级标题
						$(menuId + " .accordion-heading a").click(function(){
							$(menuId + " .accordion-toggle i").removeClass('icon-chevron-down').addClass('icon-chevron-right');
							if(!$($(this).attr('data-href')).hasClass('in')){
								$(this).children("i").removeClass('icon-chevron-right').addClass('icon-chevron-down');
							}
						});
						// 二级内容
						$(menuId + " .accordion-body a").click(function(){
						
							$(menuId + " li").removeClass("active");
							$(menuId + " li i").removeClass("icon-white");
							$(this).parent().addClass("active");
							$(this).children("i").addClass("icon-white");
						});
						// 展现三级
						$(menuId + " .accordion-inner a").click(function(){
						
						
						
							var href = $(this).attr("data-href");
							
							if($(href).length > 0){
							
								$(href).toggle().parent().toggle();
								return false;
							}
							
							
							return addTab($(this)); 
						});
						// 默认选中第一个菜单
						$(menuId + " .accordion-body a:first i").click();
						$(menuId + " .accordion-body li:first li:first a:first i").click();
					});
				}
				// 大小宽度调整
				wSizeWidth();
				return false;
			});
			// 初始化点击第一个一级菜单
			$("#menu a.menu:first span").click();
			
			
			$("#userInfo .dropdown-menu a").mouseup(function(){
				return addTab($(this), true);
			});
			// 鼠标移动到边界自动弹出左侧菜单
			$("#openClose").mouseover(function(){
				if($(this).hasClass("open")){
					$(this).click();
				}
			});
			function getNotifyNum(){
				$.get("${ctx}/oa/oaNotify/self/count?updateSession=0&t="+new Date().getTime(),function(data){
					var num = parseFloat(data);
					if (num > 0){
						$("#notifyNum,#notifyNum2").show().html("("+num+")");
					}else{
						$("#notifyNum,#notifyNum2").hide()
					}
				});
			}
			getNotifyNum(); //<c:if test="${oaNotifyRemindInterval ne '' && oaNotifyRemindInterval ne '0'}">
			setInterval(getNotifyNum, 30000); //</c:if>
		});

		function addTab($this, refresh){
		
		
			$(".jericho_tab").show();
			$("#mainFrame").hide();
			$.fn.jerichoTab.addTab({
                tabFirer: $this,
                title: $this.text(),
                closeable: true,
                data: {
                    dataType: 'iframe',
                    dataLink: "<%=basePath%>"+$this.attr('href')
                }
            }).loadData(refresh);
			return false;
		}
	</script>
</head>
<body>
	<div id="main">
		<div id="header" class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="brand">
				<span id="productName">紫荆新锐 快速开发平台</span>
				</div>
				<ul id="userControl" class="nav pull-right">
					<li><a
						href="#"
						target="_blank" title="访问网站主页"><i class="icon-home"></i>
					</a>
					</li>
					<li id="themeSwitch" class="dropdown"><a
						class="dropdown-toggle" data-toggle="dropdown" href="#"
						title="主题切换"><i class="icon-th-large"></i>
					</a>
						<ul class="dropdown-menu">
							<c:forEach items="" var="dict">
								<li><a href="#"
									onclick="location='${pageContext.request.contextPath}/theme/${dict.value}?url='+location.href">${dict.label}</a>
								</li>
							</c:forEach>
							<li><a
								href="javascript:cookie('tabmode','${tabmode eq '1' ? '0' : '1'}');location=location.href">${tabmode
									eq '1' ? '关闭' : '开启'}页签模式</a>
							</li>
						</ul> <!--[if lte IE 6]><script type="text/javascript">$('#themeSwitch').hide();</script><![endif]-->
					</li>
					<li id="userInfo" class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" title="个人信息">您好, aa&nbsp;<span
							id="notifyNum" class="label label-info hide"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="${ctx}/sys/user/info" target="mainFrame"><i
									class="icon-user"></i>&nbsp; 个人信息</a>
							</li>
							<li><a href="${ctx}/sys/user/modifyPwd" target="mainFrame"><i
									class="icon-lock"></i>&nbsp; 修改密码</a>
							</li>
							<li><a href="${ctx}/oa/oaNotify/self" target="mainFrame"><i
									class="icon-bell"></i>&nbsp; 我的通知 <span id="notifyNum2"
									class="label label-info hide"></span>
							</a>
							</li>
						</ul></li>
					<li><a href="<%=basePath %>user/logout" title="退出登录">退出</a>
					</li>
					<li>&nbsp;</li>
				</ul>

				<div class="nav-collapse">
					<ul id="menu" class="nav" style="*white-space:nowrap;float:none;">
				
								<c:forEach items="${menuList }" var="menu" varStatus="idxStatus">
								
									<c:set var="firstMenu" value="true"/>
								
							<c:if test="${menu.fatherid eq '0'}">
								<li class="menu ${not empty firstMenu && firstMenu ? ' active' : ''}">
									<%-- <c:if test="${empty menu.href}">
									</c:if> --%>
										<a class="menu" href="javascript:" data-href="${ctx}/sys/menu/tree?parentId=${menu.id}" data-id="${menu.powerid}"><span>${menu.powername}</span></a>
									
									<%-- <c:if test="${not empty menu.href}">
										<a class="menu" href="" data-id="${menu.id}" target="mainFrame"><span>${menu.powername}</span></a>
									</c:if> --%>
								</li>
								<c:if test="${firstMenu}">
									<c:set var="firstMenuId" value="${menu.id}"/>
								</c:if>
								<c:set var="firstMenu" value="false"/>
							</c:if>
						</c:forEach>
								
						
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
		
		
		
		
		
		
		<div class="container-fluid">
			<div id="content" class="row-fluid">
				<div id="left">

					
				</div>
				<div id="openClose" class="close">&nbsp;</div>
				<div id="right">
				
					<iframe id="mainFrame" name="mainFrame" src=""
						style="overflow:visible;" scrolling="yes" frameborder="no"
						width="100%" height="650"> </iframe>
				</div>
			</div>
			<div id="footer" class="row-fluid">
		
				
			</div>
		</div>
	</div>
	<script type="text/javascript"> 
		var leftWidth = 160; // 左侧窗口大小
		var tabTitleHeight = 33; // 页签的高度
		var htmlObj = $("html"), mainObj = $("#main");
		var headerObj = $("#header"), footerObj = $("#footer");
		var frameObj = $("#left, #openClose, #right, #right iframe");
		function wSize(){
			var minHeight = 500, minWidth = 980;
			var strs = getWindowSize().toString().split(",");
			htmlObj.css({"overflow-x":strs[1] < minWidth ? "auto" : "hidden", "overflow-y":strs[0] < minHeight ? "auto" : "hidden"});
			mainObj.css("width",strs[1] < minWidth ? minWidth - 10 : "auto");
			frameObj.height((strs[0] < minHeight ? minHeight : strs[0]) - headerObj.height() - footerObj.height() - (strs[1] < minWidth ? 42 : 28));
			$("#openClose").height($("#openClose").height() - 5);
			$(".jericho_tab iframe").height($("#right").height() - tabTitleHeight);
			wSizeWidth();
		}
		function wSizeWidth(){
			if (!$("#openClose").is(":hidden")){
				var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
				
				if(leftWidth==0)
				{
				leftWidth=110;
				}
				$("#right").width($("#content").width()- leftWidth - $("#openClose").width() -6);
			}else{
				$("#right").width("90%");
			}
		}
		function openCloseClickCallBack(b){
			$.fn.jerichoTab.resize();
		}
	</script>
	
				<script src="<%=basePath %>resources/common/wsize.js" type="text/javascript"></script>
	
</body>
</html>