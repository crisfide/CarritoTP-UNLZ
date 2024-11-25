

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Articulo</title>
</head>
<body>
<p>Descripcion: <c:out value="${articulo.descripcion }"></c:out></p>
<p>Precio: $<c:out value="${articulo.precio}"></c:out></p>

<form method="post" action="articulo">
	<input type="hidden" name="accion" value="delete"> 
	<input type="hidden" name="codigo" value="${articulo.codigo }"> 
	<input type="submit" value="Eliminar"> 
</form>

</body>
</html>