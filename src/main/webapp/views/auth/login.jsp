<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>Iniciar Sesión</h1>

	<form action="auth" method="post">
	               
			 		<p>
		   				  Usuario: 
		   				 <input type="text" name="usuario" required> 
		   			</p>
		   			<p>
		   			  	     Contraseña:
		   				     <input type="password" name="contraseña"  required> 
		   			</p>	
		   			
		      <input type="submit" value="Iniciar"/>
	 	
	</form>

</body>
</html>