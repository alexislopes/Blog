<%@ page import="modelo.Postagem" %><%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 11/12/2018
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String titulo = (String) request.getAttribute("titulo");
    String texto = (String) request.getAttribute("texto");
    String data = (String) request.getAttribute("data");
    Postagem postagem = new Postagem(titulo, texto, data);
%>
<html>
<head>
    <title>Postagem</title>
</head>
<body>
<div id="post">
    <h1 id="titulo"><%=titulo%></h1>
    <h6 id="data"><%=data%></h6>
    <p id="texto"><%=texto%></p>
</div>

</body>
</html>
