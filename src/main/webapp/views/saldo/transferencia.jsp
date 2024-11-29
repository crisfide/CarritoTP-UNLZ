<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transferencia</title>
</head>
<body>

 <h1> Transferencia</h1>
		<form action="saldo" method ="post">
				<input type="hidden" name="accion" value="transferir">
		       <p>Usuario:
				<select name="id">
				    <c:forEach var="usuario" items="${usuarios}">
				        <option value="${usuario.id}">${usuario.nombre}</option>
				    </c:forEach>
				</select>
				</p>
				<p>
				Cantidad: $<input value="" name="cantidad"/> 
				</p>
				
				<input type="submit" value="Transferir"/>	
		</form>		

</body>
</html>