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
				
					
          			  <div class="evenement-titre">
          			 	 <h3>	
          			 	 		<form action="<c:url value='/evenement/accueil' />" method="post">
          			 	 			<button name="action" id="actionGauche" value="p" class="btn btn-secondary font-weight-bold"><</button>
	          			 	 		<span id="calTitre"><c:out value="${(empty titre) ? 'Test' : titre}" default="test"></c:out></span>
	          			 	 		<button name="action" id="actionDroite" value="s" class="btn btn-secondary font-weight-bold">></button>
	          			 	 		<input id="anneeActuel" name="year" type="hidden" value="${current.getYear()}">
	          			 	 		<input id="moisActuel" name="month" type="hidden" value="${current.getMonthValue()}">
          			 	 		</form>
          			 	 </h3>
          			  </div>
				
						<table id="calendrier" class="table evenement-table table-bordered">
							<tbody>
								<c:forEach var="i" items="${calendrier}" varStatus="loop">
									<c:set var="index1" value="${loop.index+1}"></c:set>
									<c:set var="jours" value="${fn:split(i,'-')}"></c:set>
									<c:set var="curJourSemaine" value="${jours[0]}"></c:set>
									<fmt:parseNumber var="curJour" value="${jours[1]}"></fmt:parseNumber>
									<fmt:parseNumber var="curMois" value="${jours[2]}"></fmt:parseNumber>
									
									<!-- Première ligne -->
									<c:if test="${index1<8}">
										<c:if test="${index1==0}">
											<tr>
										</c:if> 
										<td id="<c:out value="case${index1}"></c:out>">
											<span class="cellule-jour" id="jourSemLettre"><c:out value="${curJourSemaine}"></c:out></span>
											<span class="cellule-jour" id="jourSem"><c:out value="${curJour}"></c:out></span>
											
											<!-- LES EVENEMENTS -->
											<c:forEach var="curEvent" items="${event}">
												<c:set var="eventDateDeb" value="${curEvent.getDate_debut()}"></c:set>
												<c:set var="eventDateFin" value="${curEvent.getDate_fin()}"></c:set>
												<c:set var="eventMoisDeb" value="${curEvent.getDate_debut().getMonth()+1}"></c:set>
												<c:set var="eventMoisFin" value="${curEvent.getDate_fin().getMonth()+1}"></c:set>
												
												<c:if test="${curMois>=eventMoisDeb}">
												
													<c:if test="${curMois==eventMoisDeb&&curJour>=eventDateDeb.getDate()}">
														<c:if test="${curMois==eventMoisFin&&curJour<=eventDateFin.getDate()}">
															<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
														</c:if>
														
														<c:if test="${curMois<eventMoisFin}">
															<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
														</c:if>
													</c:if>
													
													<c:if test="${curMois>eventMoisDeb}">
														<c:if test="${curMois<=eventMoisFin}">
															<c:if test="${curMois==eventMoisFin&&curJour<=eventDateFin.getDate()}">
																<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
															</c:if>
															<c:if test="${curMois>eventMoisFin}">
																<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
															</c:if>
														</c:if>
													</c:if>
												</c:if>
											</c:forEach>
											
											
										</td>
										<c:if test="${index1==7}">
											</tr>
										</c:if>
									</c:if>


									<!-- Toutes les autres lignes -->
									<c:if test="${index1>=8}">
										<c:if test="${index1%7==1}">
											<tr>
										</c:if>
										<td id="<c:out value="case${index1}"></c:out>">
											<span class="cellule-jour">
												<c:if test="${jours[2]}">
													<tr>
												</c:if>
											</span>
											<span class="cellule-jour">
												<c:out value="${jours[1]}"></c:out>
												<c:forEach var="curEvent" items="${event}">
												<c:set var="eventDateDeb" value="${curEvent.getDate_debut()}"></c:set>
												<c:set var="eventDateFin" value="${curEvent.getDate_fin()}"></c:set>
												<c:set var="eventMoisDeb" value="${curEvent.getDate_debut().getMonth()+1}"></c:set>
												<c:set var="eventMoisFin" value="${curEvent.getDate_fin().getMonth()+1}"></c:set>
												
												<c:if test="${curMois>=eventMoisDeb}">
												
													<c:if test="${curMois==eventMoisDeb&&curJour>=eventDateDeb.getDate()}">
														<c:if test="${curMois==eventMoisFin&&curJour<=eventDateFin.getDate()}">
															<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
														</c:if>
														
														<c:if test="${curMois<eventMoisFin}">
															<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
														</c:if>
													</c:if>
													
													<c:if test="${curMois>eventMoisDeb}">
														<c:if test="${curMois<=eventMoisFin}">
															<c:if test="${curMois==eventMoisFin&&curJour<=eventDateFin.getDate()}">
																<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
															</c:if>
															<c:if test="${curMois>eventMoisFin}">
																<span id="evenement" class="btn btn-success align-middle"><c:out value="${curEvent.getDescription()}"></c:out></span>
															</c:if>
														</c:if>
													</c:if>
												</c:if>
												
												
											</c:forEach>
											</span>
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