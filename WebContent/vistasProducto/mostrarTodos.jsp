<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
<style><%@include file="../resources/css/estiloProd.css" %></style>
</head>
<body>
	<h1>Listado de los Productos</h1>
	<table border="1">
		<tr>
			<td>codProd</td>
			<td>seccion</td>
			<td>nombreProd</td>
			<td>precio</td>
			<td>fecha</td>
			<td>importado</td>
			<td>pais</td>
		</tr>
		<c:forEach var="pro" items="${requestScope.listProd}">
		
		<c:url var="likTempEliminar" value="Controlador_productos">
			<c:param name="enviar" value="eliminar"></c:param>
			<c:param name="codProd" value="${pro.codProd}"></c:param>		
		</c:url>
		<c:url var="likTempAct" value="Controlador_productos">
			<c:param name="enviar" value="mostrarProducto"></c:param>
			<c:param name="codProd" value="${pro.codProd}"></c:param>	
		</c:url>
				<tr>
					<td>${pro.codProd}</td>
					<td>${pro.seccion}</td>
					<td>${pro.nombreProd}</td>
					<td>${pro.precio}</td>
					<td>${pro.fecha}</td>
					<td>${pro.importado}</td>
					<td>${pro.pais}</td>
					<td> <a href="${likTempEliminar }">Elimina</a><br>
						<a href="${likTempAct }">Actualizar</a></td>
				</tr>
		</c:forEach>
	</table>

<input type="button" name="enlace" value="Insertar" onclick="location.href='vistasProducto/insertarProductos.jsp'"/> 
</body>
</html>