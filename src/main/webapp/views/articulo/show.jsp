

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

</body>
</html>