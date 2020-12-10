<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar</title>
</head>
<body>
<h1>Insercion de un producto</h1>
<form action="../Controlador_productos" method="post">
<!-- 	<input type="hidden" name="oculto" value="insertarNuevo"> -->
	<p>Codigo de Producto:<input type="text" name="codProd"/></p>
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
	 <input type="submit" name="enviar" value="insertar"/><input type="reset" value="Restablecer"/>
</form>
</body>
</html>