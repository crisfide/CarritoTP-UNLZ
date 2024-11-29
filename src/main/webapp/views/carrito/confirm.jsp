<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Confirmar compra</title>
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
            margin-bottom: 20px;
        }

        .article-details {
            margin-bottom: 20px;
        }

        .article-details p {
            font-size: 18px;
            line-height: 1.6;
            margin: 10px 0;
        }

        .article-details span {
            font-weight: bold;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Confirmar compra</h1>
        
        <!-- Mostrar el total a pagar  -->
        <div class="article-details">
            <p><span>Total a pagar:</span> $<c:out value="${total}" /></p>
        </div>
        
        <!-- Formulario para confirmar -->
        <form method="post" action="carrito">
            <input type="hidden" name="accion" value="confirm"> 
			<button type="submit" class="button">Confirmar compra</button>
        </form>
    </div>
</body>
</html>
