<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar al carrito</title>
<style>
	input[disabled]{
		border: 0px;
		background-color: white;
	}
</style>
</head>
<body>
		<h1>Agregar al carrito</h1>
     
   		<form action="carrito" method ="post">
   				<input type="hidden" name="accion" value="agregar">
   				<p>
   				    <input type="hidden" value="${articulo.codigo}" name="codigo"/> 
   				</p>
   				<p>
   				    Descripcion: <input value="${articulo.descripcion}" name="descripcion" disabled/> 
   				</p>
   				<p>
   				    Precio: $<input value="${articulo.precio}" name="precio" disabled/> 
   				</p>
   				<p>
   				    Stock: <input value="${articulo.stock}" name="stock" disabled/> 
   				</p>
   				<p>
   				    Cantidad a comprar: <input value="" name="cantidad" type="number" min="1" required /> 
   				</p>
   				<input type="submit" value="Agregar"/>		  				
 		
   		</form>
</body>
</html>