<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Detalles del Registro</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        .article-details p {
            font-size: 18px;
            line-height: 1.6;
            margin: 10px 0;
        }

        .article-details span {
            font-weight: bold;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #5bcc00;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f0f0f0;
        }

        .button {
            display: block;
            width: 100%;
            padding: 10px 20px;
            background-color: #e74c3c;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            font-size: 18px;
            margin-top: 20px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #c0392b;
        }

        .empty-message {
            text-align: center;
            color: #888;
            font-style: italic;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Detalles del Registro</h1>
        
        <div class="article-details">
            <p><span>ID:</span> <c:out value="${registro.id}" /></p>
            <p><span>Usuario:</span> <c:out value="${registro.usuarioId}" /></p>
            <p><span>Total:</span> $<c:out value="${registro.total}" /></p>
        </div>
        
        <c:choose>
            <c:when test="${not empty registro.carrito}">
                <table>
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Descripción</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="elemento" items="${registro.carrito}">
                            <tr>
                                <td><c:out value="${elemento.articulo.codigo}"/></td>
                                <td><c:out value="${elemento.articulo.descripcion}"/></td>
                                <td>$<c:out value="${elemento.articulo.precio}"/></td>
                                <td><c:out value="${elemento.cantidad}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p class="empty-message">No hay artículos en este registro.</p>
            </c:otherwise>
        </c:choose>

        <a href="registro" class="button">Volver a la Lista</a>
    </div>
</body>
</html>
