<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elimina Usuario</title>
</head>
<body>
	<h1>Elimina por clave de usuario</h1>
	<form action="../Controlador_eliminaUsuario" method="post">
	<p>
		id_pagina:<input type="text" name="id">
	</p>
	<input type="submit" />
	</form>
</body>
</html>