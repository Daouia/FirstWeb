<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<fieldset id="menu1">
		<legend>Critère a Rechercher</legend>
		<form action="ControleurClimatisation" method="POST">
			<label>Critère </label><input type="text" value="" name="critere"
				id="critere" /><span></span><br> <input type="submit"
				value="Recherhcerc" name="rechercherc" id="boutton"/><br>
		</form>
	</fieldset>


</body>
</html>
