<%@page import="modelos.Articulo"%>
<%@page import="java.util.List"%>
<%@page import="repositories.ArticuloRepoSingleton"%>
<%@page import="repositories.interfaces.ArticuloRepo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArticuloRepo repo= ArticuloRepoSingleton.getInstance();
    List<Articulo> listaArticulos = repo.getAll();
    
    request.setAttribute("listin",listaArticulos);   
%>       
        
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Articulos</title>
</head>
<body>

		<table border ="1">
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
					 		<td><a href="www.google.com">ver</a></td>
					 		<td><a href="www.google.com">editar</a></td>
					 		
						</tr>
						
					</c:forEach>				
				</tbody>
		</table>







</body>
</html>