
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
		<h1>Editar</h1>
     
   		<form action="articulo" method ="post">
   				<input type="hidden" name="accion" value="update">
   				<p>
   				    ID: <input value="${articulo.codigo}" name="codigo"/> 
   				</p>
   				<p>
   				    Descripcion: <input value="${articulo.descripcion}" name="descripcion"/> 
   				</p>
   				<p>
   				    Precio: $<input value="${articulo.precio}" name="precio"/> 
   				</p>
   				<p>
   				    Stock: <input value="${articulo.stock}" name="stock"/> 
   				</p>
   				<input type="submit" value="Editar"/>		  				
 		
   		</form>




</body>
</html>