<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="css.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">

		<%@ include file="topnavbar.jsp"%>
		<%@ include file="sidemenu.jsp"%>

		<div id="page-content-wrapper">
			<div class="page-content">
				<div class="container-fluid"> 
						<h3 class="evenement-titre">Agenda</h3>
						<table class="table evenement-table table-bordered">
							<tbody>
								<c:forEach var="i" items="${calendrier}" varStatus="loop">
									<c:set var="index1" value="${loop.index+1}"></c:set>
									<c:set var="jours" value="${fn:split(i,'-')}"></c:set>

									<c:if test="${index1<8}">
										<c:if test="${index1==0}">
											<tr>
										</c:if> 
										<td>
											<span class="cellule-jour"><c:out value="${jours[0]}"></c:out></span>
											<span class="cellule-jour"><c:out value="${jours[1]}"></c:out></span>
										</td>
										<c:if test="${index1==7}">
											</tr>
										</c:if>
									</c:if>

									<c:if test="${index1>=8}">
										<c:if test="${index1%7==1}">
											<tr>
										</c:if>
										<td>
											<span class="cellule-jour">
												<c:if test="${jours[2]}">
													<tr>
												</c:if>
											</span>
											<span class="cellule-jour"><c:out value="${jours[1]}"></c:out></span>
										</td>

										<c:if test="${index1%7==0}">
											</tr>
										</c:if>
									</c:if>
								</c:forEach>
								
							</tbody>
						</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="js.jsp"%>
</body>
</html>