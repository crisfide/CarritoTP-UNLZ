<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Creado!!</h1>

<p>Codigo: ${articulo.codigo}  </p>
<p>Descripcion: ${articulo.descripcion}  </p>
<p>Precio: ${articulo.precio}  </p>
<p>Stock: ${articulo.stock}  </p>


<a href="articulo"> Volver al indice </a>


</body>
</html>