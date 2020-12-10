<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualiza</title>
</head>
<body>
	<c:set var="pro" value="${requestScope.productoBus}"/>
	<form action="../Controlador_productos" method="post">
<!-- 	<input type="hidden" name="oculto" value="insertarNuevo"> -->
	<p>Codigo de Producto:<input type="text" name="codProd" value="${pro.codProd }"/></p>
	<p>Seccion:<select name="seccion">
				<option value="">--Selecciona--</option>
				<option value="Ferreteria">Ferreteria</option>
				<option value="Confeccion">Confeccion</option>
				<option value="Deportes">Deportes</option>
			</select></p>
	<p>Nombre del Producto: <input type="text" name="nomProd"/></p>
	<p>Precio: <input type="text" name="precio"/></p>
	 <p>Fecha:	<input type="date" name="fecha"/></p>
	 <p>Importado:  <input type="radio" name="imp" value="true"/>SI<input type="radio" name="imp" value="false"/>No</p>
	 <p>Pais de Origen: <input type="text" name="pais"/></p>
	 <input type="submit" name="enviar" value="actualiza"/><input type="reset" value="Restablecer"/>
	 </form>
</body>
</html>