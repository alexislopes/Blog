<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 06/10/2018
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp"%>
<html>
<head>
    <title>Página Inicial</title>
    <link rel="stylesheet" type="text/css" href="/css/estiloHome.css">
    <meta CHARSET="UTF-8">
</head>

<body>

<% if(usuario != null) { %>

<div class="conteudo">
    <p>Olá usuário <%= usuario.getNome() %></p>
    <p>Seu e-mail cadastrado é: <%= usuario.getEmail() %></p>
    <p>Sua senha cadastrada é: <%= usuario.getSenha() %> </p>
    <p>Você tem privilégios de: </p>
    <ul>
        <% for(Papel p: usuario.getPapeis() ){ %>
        <li><%= p.getDescricao().toString() %></li>
        <%} %>
    </ul>
</div>

<%}%>

<div class="postagem">
    <div id="box">
        <img src="../imgs/bolo-de-cenoura.jpg">
        <a id="postagem" href="../posts/boloDeCenoura.jsp"> Bolo de Cenoura </a>
    </div>
</div>
</body>
</html>