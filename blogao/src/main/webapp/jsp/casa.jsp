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

<div hidden class="conteudo">
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
    <%for(Postagem postagem1 : postagens){%>
        <form id=<%=postagem1.getId()%>, class="postagem" action="mostrapostagem" method="post">
            <h3><%=postagem1.getTitulo()%></h3>
            <h5><%=postagem1.getData()%></h5>
            <input name="postId" hidden value=<%=postagem1.getId()%>>
            <input value="ver mais" id="btnVerMais" type="submit">
        </form>
    <%}%>
</div>


</body>
</html>