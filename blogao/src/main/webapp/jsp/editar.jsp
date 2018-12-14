<%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 12/12/2018
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp"%>
<%Usuario usuarioalterar = (Usuario) session.getAttribute("usuarioalterar");%>
<html>
<head>
    <title>Editar</title>
</head>
<body>
<div id="box" class="container">
    <form  action="atualizar" method="post">
    <input hidden name="id" value=<%=usuarioalterar.getId()%>>
    <input name="nome" placeholder="Nome" type="text" value=<%=usuarioalterar.getNome()%>>
    <input name="login" placeholder="Login" type="text" value=<%=usuarioalterar.getLogin()%>>
    <input name="senha" placeholder="Senha" type="text" value=<%=usuarioalterar.getSenha()%>>
    <input name="email" placeholder="Email" type="email" value=<%=usuarioalterar.getEmail()%>>
        <div class="butao" id="btnBemNice">
            <input class="btn" value="IR" id="btnVerMais" type="submit">
        </div>
    </form>
    <form id="formin" action="deletar" method="post">
        <input hidden name="id" value=<%=usuarioalterar.getId()%>>
        <div class="butao" id="btnBemNice2">
            <input class="btn" value="DEL" id="btnVerMais2" type="submit">
        </div>
    </form>
</div>


<style>
    body {
        background-color: white;
    }

    input[type=text], input[type=password], input[type=email] {
        width: 80%;
        padding: 12px 20px;
        display: block;
        border: 1px solid black;
        box-sizing: border-box;
        margin: 1em 0 0 3em;
    }


    button:hover {
        opacity: 0.8;
    }

    #btnVerMais, #btnVerMais2 {
        background: transparent;
        border: none;
        color: white;
        width: 100%;
        height: 100%;
        cursor: pointer;
        font-weight: bold;
    }

    #btnBemNice{
        position: absolute;
        margin: 2em 2em;

    }

    #btnBemNice2{
        position: absolute;
        margin: 1em 0 5em 25em;
    }


    div.dados{
        margin: 2em;
    }

    div.butao {
        background: black;
        width: 3em;
        height: 3em;
        border-radius: 25px;
        text-align: center;
        margin: 0 0 0 13em;
    }

    .container {
        border: 1px solid black;
        width: 30em;
        height: 20em;
        background: white;
        display: block;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        margin: 8em 0 0 25em;
    }
</style>


</body>
</html>
