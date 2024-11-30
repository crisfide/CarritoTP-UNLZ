<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Registros</title>
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
            table-layout: fixed;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        th {
            background-color: #5bcc00;
            color: white;
            position: sticky;
            top: 0;
            z-index: 2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f0f0f0;
        }

        a.table-action {
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 8px 12px;
            border-radius: 4px;
            display: inline-block;
            transition: background-color 0.3s;
        }

        a.table-action:hover {
            background-color: #0056b3;
        }

        .empty-message {
            text-align: center;
            color: #888;
            font-style: italic;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Hola, <c:out value="${sessionScope.usuario.nombre}" default="Desconocido" /></h1>
        <h1>Historial de Ventas</h1>

        <div class="nav-links">
            <c:if test="${sessionScope.usuario.rol eq 'Cliente'}">
                <a href="carrito">Ver Carrito</a>
            </c:if>
            <a href="articulo">Ver Artículos</a>
        </div>

        <c:choose>
            <c:when test="${not empty lista}">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th>Total</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="registro" items="${lista}">
                            <tr>
                                <td><c:out value="${registro.id}" /></td>
                                <td><c:out value="${registro.usuarioId}" /></td>
                                <td>$<c:out value="${registro.total}" /></td>
                                <td>
                                    <a class="table-action" href="registro?accion=show&id=${registro.id}">Ver Detalle</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p class="empty-message">No hay registros disponibles en este momento.</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
