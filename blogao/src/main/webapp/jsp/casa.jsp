<%@ page import="jpa.PostagemJPA" %>
<%@ page import="modelo.Postagem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 06/10/2018
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp"%>
<%
    String parecer = (String) request.getAttribute("parecer");
    PostagemJPA postagem = new Postagem();
    List<Postagem> postagens = postagem.achaTodas();
%>
<html>
<head>
    <title>Página Inicial</title>
    <link rel="stylesheet" type="text/css" href="/css/estiloHome.css">
    <meta CHARSET="UTF-8">
</head>

<body>

<% if(usuario != null) { %>

<div class="conteudo">
    <p>Olá, <%= usuario.getNome() %></p>
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

<div id="postagens">
    <%for(Postagem postagem1 : postagens){ %>
        <div id=<%=postagem1.getId()%>, class="postagem">
            <h3><a><%=postagem1.getTitulo()%></a></h3>
            <h5><%=postagem1.getData()%></h5>
        </div>
    <%}%>
</div>


</body>
</html>