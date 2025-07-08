<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login IMC</title>
  <style>
    body { background: #e8f5e9; font-family: Arial, sans-serif; }
    .box {
      width: 320px; margin: 80px auto; padding: 20px;
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
    .small-btn {
      font-size: 0.8em; margin-top: 5px;
      background: #fff; color: #4caf50; border: 1px solid #4caf50;
    }
    .small-btn:hover { background: #e8f5e9; }
    .error { color: red; text-align: center; margin-top: 10px; }
  </style>
</head>
<body>
  <div class="box">
    <h2>Iniciar Sesión</h2>
    <form action="LoginServlet" method="post">
      <input type="text" name="usuario" placeholder="usuario" required>
      <input type="password" name="contrasena" placeholder="contrasena" required>
      <button type="submit">Entrar</button>
    </form>
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
    </c:if>
    <form action="CrearCuenta.jsp" method="get">
      <button class="small-btn" type="submit">Crear cuenta</button>
    </form>
  </div>
</body>
</html>
