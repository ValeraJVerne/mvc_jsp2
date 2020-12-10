<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
<h1>Registro del usuario</h1>
<form action="../Controlador_InsertaUsuario" method="post">
		<p>Nombre<input type="text" name="nombre"> </p>
		<p>Apellido<input type="text" name="apellidos"> </p>
		<p>Usuario<input type="text" name="usuario"> </p>
		<p>Contraseña<input type="text" name="contrasena"> </p>
		<p>Pais<input type="text" name="pais"> </p>
		<p>Tecnologia<input type="text" name="tecnologia"> </p>
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>