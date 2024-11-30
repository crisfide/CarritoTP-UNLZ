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
        
        @media print{
            html,body, body * {		        
        		background-color: white;
        		color: black;
        		border:0px;
        		padding:5px;
        		margin:5px;
        		width: fit-content;
		      /*visibility: hidden;*/
		    }
        	button, a{
		      visibility: hidden;
        	}
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
                            <th>C�digo</th>
                            <th>Descripci�n</th>
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
                <p class="empty-message">No hay art�culos en este registro.</p>
            </c:otherwise>
        </c:choose>
        <a href="#" class="button print-button" onclick="window.print()">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-printer text-white" viewBox="0 0 16 16">
				<path d="M2 5a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h1v3a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1v-3h1a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2H2Zm11-3a1 1 0 0 1 1 1v3H2V3a1 1 0 0 1 1-1h10ZM4 12h8v3H4v-3Zm0-8V3h8v1H4Zm0 5v-2h8v2H4Zm6 2h2v2h-2v-2Z"/>
			</svg>
        	Imprimir Factura
        </a>

        <a href="registro" class="button">Volver a la Lista</a>
    </div>
</body>
</html>
