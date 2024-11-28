<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Carrito</title>
	<style>
		a{
			text-decoration:none;
		}
		a:hover{
			color:red;
		}
		td,th{
			padding:5px;
		}
	</style>
</head>
<body>

	<h1>Hola <c:out value="${sessionScope.usuario.nombre}" default="Desconocido"></c:out></h1>
	<h2>Carrito de compras</h2>
	
	<a href="articulo">Ver lista de articulos</a>
	<br>

	<table border ="1" style="border-collapse:collapse">
		<thead>
			<tr>
			<th>Codigo</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th>Stock</th>			
			<th>Cantidad en el carrito</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="elemento" items="${listaCarrito}">
			 	<tr>
			 	
		 		<td> <c:out value ="${elemento.articulo.codigo}"/> </td>
		 		<td> <c:out value ="${elemento.articulo.descripcion}"/></td>
		 		<td>$<c:out value ="${elemento.articulo.precio}"/> </td>
		 		<td> <c:out value ="${elemento.articulo.stock}"/> </td>
		 		
		 		<td> <c:out value ="${elemento.cantidad}"/> </td>
		 		
		 		<td><a href="articulo?accion=show&codigo=${elemento.articulo.codigo}">ver</a></td>

				<td><a href="carrito?accion=agregar&codigo=${elemento.articulo.codigo}">Agregar al carrito</a></td>
				<td><a href="carrito?accion=quitar&codigo=${elemento.articulo.codigo}">Quitar del carrito</a></td>
				<td><a href="carrito?accion=edit&codigo=${elemento.articulo.codigo}">Eliminar del carrito</a></td>
			 		
				</tr>				
			</c:forEach>				
		</tbody>
	</table>
	
	<br><br>
	<a href="carrito?accion=confirm">Confrimar compra</a>
	







</body>
</html>