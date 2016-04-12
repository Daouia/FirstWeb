<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Climatiseur - Saisie</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<script type="text/javascript" src="jquery.js"></script>
<script src="scriptJquery.js" type="text/javascript"></script>

</head>
<body>
	<c:if test="${not empty sessionScope.nomU}">
		<jsp:include page="AfficheNom.jsp" />
		<jsp:include page="menu.jsp" />
	</c:if>
	<fieldset id="menu1">
		<legend>Saisie Climatiseur</legend>
		<form action="ControleurClimatisation" method="POST">
			<label>Nom de l'appareil </label><input type="text" value="${nom}"
				name="nomAppareil" id="nomId"/><span>${nomE}</span><span id="nbId"></span><br> 
				<label>Temperature
			</label><input type="text" value="${temp}" name="temperature" /> <span>${tempE}</span><br>
			<label>Pression</label><input type="text" value="${pre}"
				name="pression" /> <span>${preE}</span><br> <label>Taux
				humidité</label><input type="text" value="${taux}" name="tauxHumidité" /> <span>${tauxE}</span><br>
			<input type="submit" value="Enregistrer" name="enregistrer" /> <span>${Erreur}</span><br>
		</form>
	</fieldset>


</body>

</html>
