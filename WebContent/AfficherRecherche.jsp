<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">

<title>Climatiseur - Recherche</title>
</head>
<body>
<c:if test="${not empty sessionScope.nomU}">
	<jsp:include page="AfficheNom.jsp" />
	<jsp:include page="menu.jsp" /> 
</c:if>

	<fieldset id="menu2">
		<legend>Informations Climatiseurs</legend>
		<table>
			<tr>
				<th>Nom Climatiseur</th>
				<th>Temperature</th>
				<th>Pression</th>
				<th>Taux Humidité</th>
				<th>Date de prise</th>
			</tr>
			<c:forEach items="${list}" var="climatiseur">
				<tr>

					<td>${climatiseur.nomAppareil}</td>
					<td>${climatiseur.temperature}</td>
					<td>${climatiseur.pression}</td>
					<td>${climatiseur.tauxHumidité}</td>
					<td>${climatiseur.date}</td>

				</tr>
			</c:forEach>

		</table>

	</fieldset>
</body>
</html>
