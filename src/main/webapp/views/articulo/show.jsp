<%@page import="repositories.interfaces.ArticuloRepo"%>
<%@page import="modelos.Articulo"%>
<%@page import="repositories.ArticuloRepoSingleton"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArticuloRepo repo = ArticuloRepoSingleton.getInstance();
	Articulo art = repo.findById(2);
	request.setAttribute("articulo", art);
	
%>
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