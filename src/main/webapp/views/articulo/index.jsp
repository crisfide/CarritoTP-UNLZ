
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <!--  ESTO DESPUES SE TIENE QUE SACAR -->
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
        
  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Articulos</title>
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

 <h1>Hola <c:out value="${sessionScope.usuario.nombre}" default="Desconocido"></c:out>
 
 <a href="Crear">Gestor proyectos</a>
 </h1>

	<c:if test="${sessionScope.usuario.rol eq 'Empleado'}">
	    <a href="articulo?accion=create">Agregar artículo</a>
	</c:if>
	<c:if test="${sessionScope.usuario.rol eq 'Cliente'}">
		<a href= "carrito">Ver carrito</a>
	</c:if>

	
	
	
	<br>
	<br>
	<table border ="1" style="border-collapse:collapse">
		<thead>
			<tr>
			<th>Codigo</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th>Stock</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="articulo" items="${listin}">
			 	<tr>
			 	
		 		<td> <c:out value ="${articulo.codigo}"/> </td>
		 		<td> <c:out value ="${articulo.descripcion}"/></td>
		 		<td>$<c:out value ="${articulo.precio}"/> </td>
		 		<td> <c:out value ="${articulo.stock}"/> </td>
		 		
		 		<td><a href="articulo?accion=show&codigo=${articulo.codigo}">ver</a></td>
		 		
		 		
				<c:if test="${sessionScope.usuario.rol eq 'Empleado'}">
					<td><a href="articulo?accion=edit&codigo=${articulo.codigo}">editar</a></td>
				</c:if>
				
				<!-- boton para agregar al carrito -->
				<c:if test="${sessionScope.usuario.rol eq 'Cliente'}">
					<td><a href="carrito?accion=agregar&codigo=${articulo.codigo}">Agregar al carrito</a></td>
				</c:if>
			 		
				</tr>				
			</c:forEach>				
		</tbody>
	</table>







</body>
</html>