<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Carrito de Compras</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 40px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1, h2 {
            text-align: center;
            color: #333;
        }

        .saldo-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 20px;
            background-color: #e3f2fd;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .saldo-bar a {
            color: #007bff;
            text-decoration: none;
            font-size: 16px;
        }

        .saldo-bar a:hover {
            text-decoration: underline;
        }

        .saldo-bar h1 {
            margin: 0;
            font-size: 20px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        .actions a {
            margin: 0 5px;
            padding: 8px 12px;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        .actions a:hover {
            background-color: #0056b3;
        }

        .confirm-btn {
            display: block;
            text-align: center;
            background-color: #28a745;
            color: white;
            padding: 12px 20px;
            border-radius: 8px;
            text-decoration: none;
            font-size: 18px;
            transition: background-color 0.3s;
            margin: 20px auto;
            width: fit-content;
        }

        .confirm-btn:hover {
            background-color: #218838;
        }

        .empty-msg {
            text-align: center;
            color: #777;
            font-size: 18px;
            margin: 40px 0;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Hola, <c:out value="${sessionScope.usuario.nombre}" default="Desconocido"></c:out></h1>
    <h2>Tu Carrito de Compras</h2>

    <div class="saldo-bar">
        <a href="saldo">Ver Saldo</a>
        <h1>Saldo Disponible: $ <c:out value="${sessionScope.usuario.saldo}"></c:out></h1>
        <a href="articulo">Ver Lista de Artículos</a>
		<a href="registro">Ver historial de ventas</a>
        
    </div>

    <c:choose>
        <c:when test="${empty listaCarrito}">
            <p class="empty-msg">Tu carrito está vacío.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Cantidad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="elemento" items="${listaCarrito}">
                        <tr>
                            <td><c:out value="${elemento.articulo.codigo}"/></td>
                            <td><c:out value="${elemento.articulo.descripcion}"/></td>
                            <td>$<c:out value="${elemento.articulo.precio}"/></td>
                            <td><c:out value="${elemento.articulo.stock}"/></td>
                            <td><c:out value="${elemento.cantidad}"/></td>
                            <td class="actions">
                                <a href="articulo?accion=show&codigo=${elemento.articulo.codigo}">Ver</a>
                                <a href="carrito?accion=agregar&codigo=${elemento.articulo.codigo}">Agregar</a>
                                <a href="carrito?accion=quitar&codigo=${elemento.articulo.codigo}">Quitar</a>
                                <a href="carrito?accion=edit&codigo=${elemento.articulo.codigo}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="confirm-btn" href="carrito?accion=confirm">Confirmar Compra</a>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
