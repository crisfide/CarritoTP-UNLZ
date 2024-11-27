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
	

<form action="auth" method="post" style="max-width: 300px; margin: auto; font-family: Arial, sans-serif; border: 1px solid #ccc; padding: 20px; border-radius: 8px;">
    <h2 style="text-align: center;">Iniciar Sesión</h2>

    <div style="margin-bottom: 15px;">
        <label for="usuario" style="display: block; font-weight: bold; margin-bottom: 5px;">Usuario:</label>
        <input type="text" id="usuario" name="usuario" required 
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px;">
    </div>

    <div style="margin-bottom: 15px;">
        <label for="contraseña" style="display: block; font-weight: bold; margin-bottom: 5px;">Contraseña:</label>
        <input type="password" id="contraseña" name="contraseña" required 
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px;">
    </div>

    <div style="text-align: center;">
        <input type="submit" value="Iniciar" 
               style="background-color: #4CAF50; color: white; border: none; padding: 10px 20px; cursor: pointer; border-radius: 4px;">
    </div>
    <br>
	<div style="color:red; text-align:center" id="Error">
		<b><c:out value="${error}"></c:out></b>	
	</div>
</form>



</body>
</html>