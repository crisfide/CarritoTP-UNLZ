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
	<c:out value="${logueado.descripcion}" />
	</p>

<p>
	Presupuesto: $ 
	<c:out value="${proyecto.presupuesto }" />
	
		<table border="1">
			<thead>
				<tr>
					<th>Descripcion</th>
					<th>Tarea</th>
					<th>Precio</th>
									
				</tr>
			</thead>
			 <tbody>
					<c:forEach var="tupla" items="${proyecto.tuplas}">
						<tr>
							<td>${tupla.articulo.descripcion}</td>
							<td>${tupla.tarea}</td>
							<td>$${tupla.articulo.precio}</td>
							
						</tr>
					</c:forEach>
					
					<tr> 
						<td colspan="2">Total </td>
							
							<td>$${proyecto.total}</td>
					
					</tr>
					
					
			</tbody>
			
		
		</table>
		
		
		<c:if test="${proyecto.presupuesto < proyecto.total}">
			<c:out value="El proyecto se fue (NO HAY PLATA)"/>
		
		</c:if>
	
	
	</p>
	
	
	
	<h3>Agregar articulo</h3>
	<form action="Crear" method="post"> 			
			<input type="hidden" value="agregarart" name="accion">
				<select name="articulo">
					<c:forEach var="articulo" items="%{articulos }">
						<option value="${articulo.codigo }"> ${articulo.descripcion} - ${articulo.stock } </option>
				
					</c:forEach>
				</select>
			<input name="tarea" />
			<input type="submit"></form>
	
	
	<h3>Cambiar presupuesto</h3>
	<form action="Crear" method="post">
			<input type="hidden" value="modifpre" name="accion">
			<input name="importe" />
			<input type="submit">
		</form>
		
		
		
		<h3>Finalizar</h3>
		
		
		<form action="Crear" method="post">
			<input type="hidden" value="finalizar">
			<input name="accion" />
			<input type="submit">
		</form>
	
	
	
		<!--BOTON-->
		<!--
		<form action="Crear" method="post">
    		<input type="hidden" name="accion" value="finalizar">
    		<button type="submit">Finalizar</button>
		</form>
		-->





</body>
</html>