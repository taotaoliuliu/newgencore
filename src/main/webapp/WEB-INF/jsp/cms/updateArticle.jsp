<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

  
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
<c:set var="ctx" value="<%=basePath %>"/>

<script src="<%=basePath %>resources/jquery/jquery-2.1.1.min.js" type="text/javascript"></script>

<script type="text/javascript" charset="utf-8"
	src="<%=basePath %>resources/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath %>resources/ueditor/ueditor.all.js">
</script>



 <script src="<%=basePath %>resources/fileinput/js/fileinput.js" type="text/javascript"></script>
    <script src="<%=basePath %>resources/fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>
    
    <link href="<%=basePath %>resources/fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	
    	<link href="<%=basePath %>resources/bootstrap/3.3.5/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <script src="<%=basePath%>resources/bootstrap/3.3.5/js/bootstrap.min.js" type="text/javascript"></script>

<link rel="stylesheet"
		href="<%=basePath %>css/core.css" />




<script type="text/javascript">



window.onload=function(){


	var ue = UE.getEditor('editor');
	
 


};

function check(){


		var arr = [];
		arr.push(UE.getEditor('editor').getContent());
		$("#content").val(arr.join("\n"));



}	
	



</script>
</head>

<body>
 	<ul class="nav nav-tabs">
		<li ><a
			href="<%=basePath%>cms/getArtilceByCategory.do">文章列表</a>
		</li>
		<li class="active"><a
			href="<%=basePath%>cms/addArticleUI.do">文章添加</a>
		</li>
	</ul>
<br>


	<form id="saveuser" class="form-horizontal" role="form" action="<%=basePath%>cms/update.do" method="post" onsubmit="return check()">
		<input type="hidden" name="id" value="${article.id}">
		<input type="hidden" name="filename"  id="filename" value="${article.filename}">
		<input type="hidden" name="filepath" id="filepath" value="${article.filepath}">
		  
		  	 <input name="content" id="content" type="hidden" /> 
		  

		<div class="form-group">
			<label for="loginname" class="col-sm-2 control-label">归属栏目</label>
			<div class="col-sm-3" style="height: 35px;">
		
			  <sys:treeselect id="category" name="category.id" value="" labelName="category.name" labelValue=""
					title="栏目" base="${ctx }" url="${ctx }/category/treeData.do" module="article" selectScopeModule="true" notAllowSelectRoot="false" notAllowSelectParent="true" cssClass=""/>&nbsp;
			
			</div>

			
		</div>
		
		
		
		
		
		<div class="form-group" >
			<label for="loginname" class="col-sm-2 control-label">标题</label>
			<div class="col-sm-3">
				<input type="text" id="title" class="form-control input-xxlarge measure-input required" name="title"
					placeholder="" value="${article.title }">

			</div>

			
		</div>
		
		
		
		
		<div class="form-group">
			<label for="loginname" class="col-sm-2 control-label">关键字</label>
			<div class="col-sm-3">
				<input type="text" id="keyword" class="form-control" name="keyword"
					placeholder="" value="${article.keyword }">

			</div>

			
		</div>
		
		
		<div class="form-group">
			<label  class="col-sm-2 control-label">摘要</label>
			<div class="col-sm-3">
				<textarea rows="4" maxlength="200" name="digest" class="input-xxlarge">${article.digest }</textarea>
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-2 control-label">封面图</label>
			<div class="col-sm-4">

                    <input id="file-5" class="file" type="file" multiple data-preview-file-type="any" data-upload-url="<%=basePath%>cms/upload.do" data-preview-file-icon="">
            </div>
		</div>
		
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">正文</label>
			<div class="col-sm-7">
				<script id="editor" type="text/plain" style="width:100%;height:300px;">${article.articleData.content  }</script>
				
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">来源</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="source" name="source"
					placeholder="" value="${article.source}"> 
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


<script type="text/javascript">
  $("#file-5").fileinput({
	      language: 'zh', //设置语言
                uploadUrl: "/cms/upload.do", //上传的地址
                allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
                maxFileCount: 1,
                uploadAsync: false,
    			showPreview: true,
                enctype: 'multipart/form-data',
                showUpload: true, //是否显示上传按钮
                showCaption: false,//是否显示标题
                browseClass: "btn btn-primary", //按钮样式             
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
              previewSettings:{
            image: {width: "auto", height: "20px"}
            },
           <c:if test="${article.filename!=null&&article.filename!='' }">
                  initialPreview: [
        "<img style='height:160px' src='${imgServerPath}${article.filepath}/L_${article.filename}'>"    ],
        
        	initialPreviewConfig: [
        {caption: "City-1.jpg", width: "120px", url: "<%=basePath%>/cms/deleteFile.do", key: 1}
    ]
           
           </c:if>
  
		}).on('filebatchpreupload', function(event, data, id, index) {
		}).on('filebatchuploadsuccess', function(event, data) {


	$("#filename").val(data.response.filename);
	$("#filepath").val(data.response.filepath);
}).on("filepredelete", function(jqXHR) {
    var abort = true;
    if (confirm("确定要删除该照片吗？")) {
    
     top.jBox.tip("删除成功！", 'info');
        abort = false;
    }
    return abort; // you can also send any data/object that you can receive on `filecustomerror` event
});;


</script>
</html>
