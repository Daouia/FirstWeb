<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
</head>
<body>
<fieldset id="connexion">
    <legend>Connectez vous</legend>
	<form action="Connexion" method="POST" id="formConnexion">
	<label>Nom de l'utilisateur </label><input type="text"  value="" name="nomUtilisateur" /><span>${nomUE}</span><br>
	<label>Mot de passe </label><input type="text"  value="${passeU}" name="passeUtilisateur" /><br> 
	<input type="submit" value="Connecter" name="connecter" id="connecter"/>
	<input type="submit" value="S'inscrire" name="inscrire" id="inscrire" />  
	</form>
	</fieldset>
</body>
</html>