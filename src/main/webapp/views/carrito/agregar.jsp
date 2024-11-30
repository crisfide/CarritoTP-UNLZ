<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Agregar al Carrito</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 600px;
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

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
            color: #555;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[disabled] {
            background-color: #f5f5f5;
            border: none;
        }

        input[type="submit"] {
            background-color: #5bcc00;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 18px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #4da500;
        }

        .back-link {
            text-align: center;
            margin-top: 20px;
        }

        .back-link a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            transition: color 0.3s;
        }

        .back-link a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Agregar al Carrito</h1>
        <form action="carrito" method="post">
            <input type="hidden" name="accion" value="agregar">
            <input type="hidden" value="${articulo.codigo}" name="codigo">

            <label>Descripción:</label>
            <input type="text" value="${articulo.descripcion}" name="descripcion" disabled>

            <label>Precio:</label>
            <input type="text" value="$${articulo.precio}" name="precio" disabled>

            <label>Stock disponible:</label>
            <input type="text" value="${articulo.stock}" name="stock" disabled>

            <label>Cantidad a comprar:</label>
            <input type="number" name="cantidad" min="1" max="${articulo.stock}" required>

            <input type="submit" value="Agregar al Carrito">
        </form>
        
        <div class="back-link">
            <a href="articulo">Volver a Artículos</a>
        </div>
    </div>
</body>
</html>
