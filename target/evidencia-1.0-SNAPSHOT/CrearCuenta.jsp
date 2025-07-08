<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Crear Cuenta</title>
  <style>
    body { background: #e8f5e9; font-family: Arial, sans-serif; }
    .box {
      width: 320px; margin: 60px auto; padding: 20px;
      background: #fff; border: 2px solid #a5d6a7; border-radius: 8px;
      box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    h2 { text-align: center; color: #2e7d32; font-size: 1.4em; }
    input {
      width: 100%; padding: 8px; margin: 10px 0 5px;
      border-radius: 4px; border: 1px solid #ccc;
    }
    button {
      width: 100%; padding: 10px; margin-top: 8px;
      background: #4caf50; color: white;
      border: none; border-radius: 4px;
      cursor: pointer;
    }
    button:hover { background: #388e3c; }
    .error { color: red; text-align: center; margin-top: 10px; }
  </style>
</head>
<body>
  <div class="box">
    <h2>Registro</h2>
    <form action="RegistroServlet" method="post">
      <input type="text" name="nombre" placeholder="Nombre completo" required>
      <input type="text" name="usuario" placeholder="Usuario" required>
      <input type="password" name="contrasena" placeholder="Contraseña" required>
      <input type="number" name="edad" placeholder="Edad" min="15" required>
      <input type="text" name="sexo" placeholder="Sexo (M/F)" maxlength="1" required>
      <input type="number" name="estatura" placeholder="Estatura (m)" step="0.01" min="1" max="2.5" required>
      <button type="submit">Registrar</button>
    </form>
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
    </c:if>
  </div>
</body>
</html>
