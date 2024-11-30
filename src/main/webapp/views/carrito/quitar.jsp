<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Quitar del carrito</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 100%;
            max-width: 400px;
        }

        h1 {
            color: #333;
            font-size: 24px;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-size: 16px;
            color: #555;
            margin-bottom: 5px;
            text-align: left;
        }

        input[type="text"], input[type="number"], input[disabled] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            background-color: #f9f9f9;
        }

        input[type="submit"] {
            background-color: #e74c3c;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Quitar del carrito</h1>
        <form action="carrito" method="post">
            <input type="hidden" name="accion" value="quitar">
            <input type="hidden" value="${articulo.codigo}" name="codigo"/>

            <label for="descripcion">Descripción:</label>
            <input id="descripcion" value="${articulo.descripcion}" name="descripcion" disabled/>

            <label for="precio">Precio:</label>
            <input id="precio" value="$${articulo.precio}" name="precio" disabled/>

            <label for="stock">Stock Disponible:</label>
            <input id="stock" value="${articulo.stock}" name="stock" disabled/>

            <label for="cantidad">Cantidad a quitar:</label>
            <input id="cantidad" type="number" name="cantidad" min="1" placeholder="Ingresa la cantidad" required/>

            <input type="submit" value="Quitar">
        </form>
    </div>

</body>
</html>
