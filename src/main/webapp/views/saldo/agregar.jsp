<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar saldo</title>
</head>
<body>

 <h1> Saldo </h1>
		<form action="saldo" method ="post">
				<input type="hidden" name="accion" value="agregar">
		       
				<p>
				Cantidad: $<input value="" name="cantidad"/> 
				</p>
				
				<input type="submit" value="Agregar"/>	
		</form>		

</body>
</html>