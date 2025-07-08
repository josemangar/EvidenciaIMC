<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Ingreso de Datos IMC</title>
  <style>
    body { background: #f1f8e9; font-family: Verdana, sans-serif; }
    .card {
      width: 360px; margin: 60px auto; padding: 18px;
      background: #fff; border: 1px solid #c8e6c9; border-radius: 8px;
      box-shadow: 0 1px 4px rgba(0,0,0,0.1);
    }
    h2 { text-align: center; color: #33691e; margin-bottom: 10px; }
    label {
      display: block; margin-top: 14px;
      color: #555; font-size: 0.9em;
    }
    input {
      width: 100%; padding: 7px; margin-top: 3px;
      border: 1px solid #bbb; border-radius: 4px;
    }
    button {
      width: 100%; padding: 10px; margin-top: 16px;
      background: #8bc34a; color: white; border: none;
      border-radius: 4px; cursor: pointer; font-weight: bold;
    }
    button:hover { background: #558b2f; }
    .error { color: red; text-align: center; margin-top: 8px; }
    small {
      font-size: 0.8em; color: #777; display: block; text-align: center; margin-top: 8px;
    }
  </style>
</head>
<body>
  <div class="card">
    <h2>Ingresa tus datos</h2>
    <form action="RegistroIMC" method="post">
      <label>Peso (kg):</label>
      <input type="number" name="peso" step="0.1" required>
      <button type="submit">Calcular IMC</button>
    </form>
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
    </c:if>
    <small>* todos los campos obligatorios</small>
  </div>
</body>
</html>
