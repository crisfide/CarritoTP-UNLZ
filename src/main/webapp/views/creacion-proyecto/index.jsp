<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creacion proyecto</title>
</head>
<body>


<h1>Binevenido al creador de proyectos</h1>


<p>
	Articulo:  
	<c:out value="${proyecto.lider.descripcion}" />
	</p>

<p>
	Presupuesto: $ 
	<c:out value="${proyecto.presupuesto }" />
	</p>
	
	
	
	
	
	
	<h3>Cambiar presupuesto</h3>
	<form action="Crear" method="post" name="accion">
			<input type="hidden" value="modifpre">
			<input name="importe" />
			<input type="submit">
		</form>
	
	


</body>
</html>