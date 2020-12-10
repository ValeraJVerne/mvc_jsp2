<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar</title>
</head>
<body>
<h1>Teclee el nombre y la contraseña del usuario a modificar</h1>

<form action="${pageContext.request.contextPath}/Controlador_actualizaUsuario" method="post">
		<p>Usuario<input type="text" name="usuario"> </p>
		<p>Contraseña<input type="text" name="contrasena"> </p>
		
		<input type="submit" value="Busca Usuario" name="buscaUsuario"/>
		
		<c:set var="usu" value="${sessionScope.usuarioEncontrado }" />
		
		<p>id<input type="text" name="id" value="${usu.id_usuario}"> </p>
		<p>Nombre<input type="text" name="nombre" value="${usu.nombre}"> </p>
		<p>Apellido<input type="text" name="apellidos" value="${usu.apellidos}"> </p>
		<p>Usuario<input type="text" name="usuario" value="${usu.usuario}"> </p>
		<p>Contraseña<input type="text" name="contrasena" value="${usu.contrasena}"> </p>
		<p>Pais<input type="text" name="pais" value="${usu.pais}"> </p>
		<p>Tecnologia<input type="text" name="tecnologia" value="${usu.tecnologia}"> </p>
		
		<input type="submit" value="Actualiza usuario" name="actualizaUsuario"/>
	</form>
</body>
</html>