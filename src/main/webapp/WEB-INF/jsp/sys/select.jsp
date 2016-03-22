<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'select.jsp' starting page</title>
    <script src="<%=basePath %>jeesite/jquery/jquery-1.8.3.min.js"
	type="text/javascript"></script>
	<link href="<%=basePath %>jeesite/jquery-select2/3.4/select2.min.css"
	rel="stylesheet" />
<script src="<%=basePath %>jeesite/jquery-select2/3.4/select2.min.js"
	type="text/javascript"></script>
	
	<script type="text/javascript">
	
	
       $(document).ready(function() { 
        
        //  $(".js-example-basic-single").select2();
          
          $(".js-example-basic-multiple").select2({ theme: "classic"});
          
        
        });
	
	</script>

  </head>
  
  <body>
  
  
  
  



<select class="js-example-basic-multiple" multiple="multiple">
  <option value="AL">Alabama</option>
  <option value="WY">Wyoming</option>
</select>

<select class="js-example-basic-single">
  <option value="AL">Alabama</option>
  <option value="WY">Wyoming</option>
</select>



  </body>
</html>
