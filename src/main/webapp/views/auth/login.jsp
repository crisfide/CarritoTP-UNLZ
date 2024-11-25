<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="auth" method="post">
<p>
    Usuario:
	<select>
	 <c:forEach var="usuario" items="${usuarios}">
	 	<option value="${usuario.nombre}"> ${usuario.nombre} </option>
	 </c:forEach>
	</select>
</p>	

 <input type="submit" value="identificarse"/>
 	
</form>

</body>
</html>