<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
			<div style="display: inline-table;margin-top: 10px; float: right; margin-right: 100px;">
		
				<ul class="pagination pagination-lg">
				
				<li> 
				
				<span class="label label-default" style="margin-right: 5px;">
${pageview.pageSize }/${pageview.rowCount }</span> 
				</li>

					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span> </a>
					</li>
					<c:forEach begin="${pageview.beginPageIndex }"
						end="${pageview.endPageIndex }" var="num">
						<c:choose>

							<c:when test="${num==pageview.pageNow }">

								<li class="active"><a href="#">${num}</a></li>
							</c:when>

							<c:otherwise>
								<li><a href="javascript:gotoPage(${num})">${num}</a></li>


							</c:otherwise>

						</c:choose>
					</c:forEach>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span> </a>
					</li>
					<li>
					
				<label style="font-size: 15px;">	 <input class="input"  type="text" id="pageNum2" name="pageNum2"
						value="${currentPage }"
						style="width: 50px;height: 40px;border-radius:5px;margin-left: 5px;" /></label>
					</li>
					<li>
				
						
			<button type="button" onclick="go(${pageCount }, ${currentPage })" class="btn btn-primary">查询</button>
						
					
					</li>

				</ul>
			</div>
		


	<script type="text/javascript">
	function gotoPage( pageNow ){
		 //window.location.href = "topicAction_show.action?id=${topic.id}&pageNum=" + pageNum;
		
		$(document.forms[0]).append("<input type='hidden' name='pageNow' value='" + pageNow + "'/>");
		document.forms[0].pageNow.value = pageNow;
		

		
		alert(document.forms[0].pageNow.value);
		
		document.forms[0].submit(); // 提交表单
	}
	
	function go(totalPageNum, defaultValue) {
  		// 获得文本框输入的内容
  		var pageNumObj = document.getElementById("pageNum2");
  		var pageNum = pageNumObj.value;
  		if(pageNum==null || pageNum=="") {
  			alert("页数不能为空");
  			pageNumObj.value = defaultValue;
  			return;
  		}
  		var num = parseInt(pageNum);	// NaN  not a number
  		if(isNaN(num)) {
  			alert("请输入一个数字");
  			pageNumObj.value = defaultValue;
  			return ;
  		}
  		if(num<1 || num>totalPageNum) {
  			alert("对不起！没有这一页");
  			pageNumObj.value = defaultValue;
  			return;
  		}
  	$(document.forms[0]).append("<input type='hidden' name='pageNum' value='" + pageNum + "'/>");
  		
  		document.forms[0].submit();
	}
</script>
