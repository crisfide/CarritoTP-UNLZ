
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <!--  ESTO DESPUES SE TIENE QUE SACAR -->
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
        
  
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Artículos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            margin: 40px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .nav-links {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .nav-links a {
            text-decoration: none;
            color: #007bff;
            padding: 10px 20px;
            border: 1px solid #007bff;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }

        .nav-links a:hover {
            background-color: #007bff;
            color: white;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a.table-action {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a.table-action:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        
        <h1>Hola, <c:out value="${sessionScope.usuario.nombre}" default="Desconocido" /></h1>

        
        <div class="nav-links">
            
            <c:if test="${sessionScope.usuario.rol eq 'Empleado'}">
                <a href="articulo?accion=create">Agregar Artículo</a>
            </c:if>
            
         
            <c:if test="${sessionScope.usuario.rol eq 'Cliente'}">
                <a href="carrito">Ver Carrito</a>
            </c:if>
            
      
            <a href="Crear">Gestor Proyectos</a>
        </div>

   
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Stock</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
            
                <c:forEach var="articulo" items="${listin}">
                    <tr>
                        <td><c:out value="${articulo.codigo}" /></td>
                        <td><c:out value="${articulo.descripcion}" /></td>
                        <td>$<c:out value="${articulo.precio}" /></td>
                        <td><c:out value="${articulo.stock}" /></td>
                        <td>
                         
                            <a class="table-action" href="articulo?accion=show&codigo=${articulo.codigo}">Ver</a>
                            
                        
                            <c:if test="${sessionScope.usuario.rol eq 'Empleado'}">
                                | <a class="table-action" href="articulo?accion=edit&codigo=${articulo.codigo}">Editar</a>
                            </c:if>
                            
                            <!-- Solo clientes pueden agregar artículos al carrito -->
                            <c:if test="${sessionScope.usuario.rol eq 'Cliente'}">
                                | <a class="table-action" href="carrito?accion=agregar&codigo=${articulo.codigo}">Agregar al Carrito</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>