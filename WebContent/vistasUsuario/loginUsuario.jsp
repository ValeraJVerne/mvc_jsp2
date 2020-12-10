<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">h1{text-align:center}</style>
</head>
<body>
<h1>Registro del usuario</h1>
<form action="../Controlador_loginUsuario" method="post">
		<p>Usuario<input type="text" name="usuario"> </p>
		<p>Contraseña<input type="text" name="contrasena"> </p>
		<input type="submit" value="login" />
	</form>
</body>
</html>