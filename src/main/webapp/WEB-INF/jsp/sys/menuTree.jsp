<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>






	<div class="accordion" id="menu-${parentId}">
	<c:set var="firstMenu" value="true"/>
	<c:forEach items="${menuList}" var="menu" varStatus="idxStatus">
		<c:if
			test="${menu.powerid eq parentId}">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#menu-${parentId}"
						data-href="#collapse-${menu.powerid}" href="#collapse-${menu.powerid}"
						title=""><i
						class="icon-chevron-${not empty firstMenu && firstMenu ? 'down' : 'right'}"></i>&nbsp;${menu.powername}</a>
				</div>
				<div id="collapse-${menu.powerid}"
					class="accordion-body collapse ${not empty firstMenu && firstMenu ? 'in' : ''}">
					<div class="accordion-inner">
						<ul class="nav nav-list">
							<c:forEach items="${menuList}" var="menu2">
								<c:if test="${menu2.fatherid eq menu.powerid}">
									<li><a data-href=".menu3-${menu2.powerid}"
										href="${menu2.powerurl }"
										target="mainFrame"><i
											class="icon-${not empty menu2.imgurl ? menu2.imgurl : 'circle-arrow-right'}"></i>&nbsp;${menu2.powername}</a>
										<ul class="nav nav-list hide"
											style="margin:0;padding-right:0;">
											<c:forEach items="${menuList}" var="menu3">
												<c:if
													test="${menu3.fatherid eq menu2.powerid}">
													<li class="menu3-${menu2.powerid}"><a
														href=""
														target="mainFrame"><i
															class="icon-${not empty menu3.imgurl ? menu3.imgurl : 'circle-arrow-right'}"></i>&nbsp;${menu3.powername}</a>
													</li>
												</c:if>
											</c:forEach>
										</ul>
									</li>
									<c:set var="firstMenu" value="false" />
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:if>

	</c:forEach>
	
	
	</div>