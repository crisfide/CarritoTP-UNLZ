
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <!--  ESTO DESPUES SE TIENE QUE SACAR -->
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
        
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Articulos</title>
</head>
<body>


<a href= "articulo?accion=create">Agregar articulo</a>

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
					 		<td><a href="articulo?accion=edit&codigo=${articulo.codigo}">editar</a></td>
					 		
						</tr>
						
					</c:forEach>				
				</tbody>
		</table>







</body>
</html>