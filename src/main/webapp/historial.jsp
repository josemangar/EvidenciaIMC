<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Registro" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Resultado & Historial</title>
  <style>
    body { background: #e8f5e9; font-family: Tahoma, sans-serif; }
    .main {
      width: 600px; margin: 40px auto; padding: 20px;
      background: #fff; border: 1px solid #c8e6c9;
      border-radius: 6px; box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    h2 { color: #2e7d32; text-align: center; }
    .resultado {
      text-align: center; margin: 20px 0; font-size: 1.1em; color: #333;
    }
    table {
      width: 100%; border-collapse: collapse; margin-top: 20px;
    }
    th, td {
      border: 1px solid #ddd; padding: 8px; text-align: center;
    }
    th { background: #a5d6a7; color: #fff; }
    tr:nth-child(even) { background: #f9f9f9; }
    a {
      display: inline-block; margin: 15px 10px 0;
      color: #4caf50; text-decoration: none; font-size: 0.9em;
    }
    a:hover { text-decoration: underline; }
  </style>
</head>
<body>
  <div class="main">
    <h2>Tu IMC y Historial</h2>
    <div class="resultado">
      <p>IMC calculado: <strong>${imc}</strong></p>
      <p>Categoría: <strong>${cat}</strong></p>
    </div>
    <h3>Historial</h3>
    <table>
      <tr>
        <th>Fecha</th>
        <th>Peso (kg)</th>
        <th>Estatura (m)</th>
        <th>IMC</th>
        <th>Categoría</th>
      </tr>
      <c:forEach var="r" items="${registros}">
        <tr>
          <td>${r.fecha}</td>
          <td>${r.peso}</td>
          <td>${r.imc}</td>
          <td>${r.imc}</td>
          <td>${r.categoria}</td>
        </tr>
      </c:forEach>
    </table>
    <a href="imcForm.jsp">Calcular de nuevo</a>
    <a href="LogoutServlet">Cerrar sesión</a>
  </div>
</body>
</html>
