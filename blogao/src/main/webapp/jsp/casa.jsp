<%@ page import="jpa.PostagemJPA" %>
<%@ page import="modelo.Postagem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.mysql.cj.xdevapi.Collection" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 06/10/2018
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp" %>
<%
    String parecer = (String) request.getAttribute("parecer");
    PostagemJPA postagem = new Postagem();
    List<Postagem> postagens = postagem.achaTodas();
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Collections.reverse(postagens);
%>
<html>
<head>
    <title>Página Inicial</title>
    <link rel="stylesheet" type="text/css" href="/css/estiloHome.css">
    <meta CHARSET="UTF-8">
</head>

<body>

<% if (usuario != null) { %>

<div hidden class="conteudo">
    <p>Olá, <%= usuario.getNome() %>
    </p>
    <p>Seu e-mail cadastrado é: <%= usuario.getEmail() %>
    </p>
    <p>Sua senha cadastrada é: <%= usuario.getSenha() %>
    </p>
    <p>Você tem privilégios de: </p>
    <ul>
        <% for (Papel p : usuario.getPapeis()) { %>
        <li><%= p.getDescricao().toString() %>
        </li>
        <%} %>
    </ul>
</div>

<%}%>

<div id="postagens">
    <%for (Postagem postagem1 : postagens) {%>
    <div class="postagem">
        <form id=<%=postagem1.getId()%>, action="mostrapostagem" method="post">
            <div class="data">
                <h5><%=postagem1.getDataDiaMes()%></h5>
            </div>
            <h3><%=postagem1.getTitulo().toUpperCase()%>
            </h3>
            <label class="formLabel">
                <input name="postId" hidden value=<%=postagem1.getId()%>>
            </label>
            <div class="butao">
                <input class="btn" value="VER" id="btnVerMais" type="submit">
            </div>
        </form>
    </div>
    <%}%>
</div>

<style>
    body {
        margin: 0;
        background-color: white;

    }

    form {
        display: flex;
    }

    form h5 {
        background: transparent;
        color: white;
        font-size: 15px;
        text-align: center;
        width: 100%;
        height: 100%;
    }

    div.data {
        background: black;
        width: 3em;
        height: 3em;
        text-align: center;
        margin: 1em;
    }

    form h3 {
        background-color: white;
        color: black;
        text-align: center;
        font-size: 24px;
        padding: 0.5px;
        border: 1px solid black;

    }

    #btnVerMais {
        background: transparent;
        border: none;
        color: white;
        width: 100%;
        height: 100%;
        cursor: pointer;
        font-weight: bold;
    }

    div.butao {
        background: black;
        width: 3em;
        height: 3em;
        border-radius: 25px;
        text-align: center;
        justify-content: center;
        align-items: center;
        horiz-align: center;
        margin: 1em 0 0 1em ;
    }

    div#postagens {
        position: center;
        width: fit-content;
        height: fit-content;
        margin: auto;
        background: white;
        display: block;
        justify-content: center;
        align-items: center;
        alignment: center;

    }





    .postagem {
        width: fit-content;
        background: transparent;
        display: flex;
        align-content: center;
        align-items: center;
    }

</style>

</body>
</html>