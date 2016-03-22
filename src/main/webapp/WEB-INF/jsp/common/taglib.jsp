<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>



<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value="<%=basePath %>"/>

<script src="<%=basePath %>resources/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
<link
	href="<%=basePath%>resources/bootstrap/3.3.5/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<script src="<%=basePath%>resources/bootstrap/3.3.5/js/bootstrap.min.js"
	type="text/javascript"></script>
<link href="<%=basePath %>resources/bootstrap/2.3.1/awesome/font-awesome.min.css"
	type="text/css" rel="stylesheet" />
<script src="<%=basePath %>resources/bootstrap/bsie/js/bootstrap-ie.min.js" type="text/javascript"></script>
<link href="<%=basePath %>resources/jquery-select2/3.4/select2.min.css"
	rel="stylesheet" />
<script src="<%=basePath %>resources/jquery-select2/3.4/select2.min.js"
	type="text/javascript"></script>
<link
	href="<%=basePath %>resources/jquery-validation/1.11.0/jquery.validate.min.css"
	type="text/css" rel="stylesheet" />
<script
	src="<%=basePath %>resources/jquery-validation/1.11.0/jquery.validate.min.js"
	type="text/javascript"></script>
<link href="<%=basePath %>resources/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css"
	rel="stylesheet" />
<script src="<%=basePath %>resources/jquery-jbox/2.3/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
	
		<link href="<%=basePath %>resources/jquery-ztree/3.5.12/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=basePath %>resources/jquery-ztree/3.5.12/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
		
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
		
		<link rel="stylesheet" type="text/css"	href="<%=basePath %>css/core.css" />