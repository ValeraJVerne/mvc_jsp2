<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Usuario</title>
</head>
<body>
<h2>Listado de los usuarios</h2>
<c:set var="usu" value="${requestScope.usuarioBuscado}"/>
<table border="1">
<tr>
<td>id_usuario</td>
<td>nombre</td>
<td>apellidos</td>
<td>usuario</td>
<td>contrasena</td>
<td>pais</td>
<td>tecnologia</td>
</tr>
<tr>
<td>${usu.id_usuario}</td>
<td>${usu.nombre}</td>
<td>${usu.apellidos}</td>
<td>${usu.usuario}</td>
<td>${usu.contrasena}</td>
<td>${usu.pais}</td>
<td>${usu.tecnologia}</td>
</tr>
</table>
</body>
</html>