<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 06/10/2018
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String contexto = request.getContextPath();
    if (!contexto.equals("")) contexto = contexto + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<div class="container">
    <form class="baseForm" action="validador" method="post">

        <div class="dados">
            <label class="formLabel">
                <input name="nomeUsuario" placeholder="Usuário" type="text" required class="formInput formTextInput">
            </label>
            <label class="formLabel">

                <input name="senha" placeholder="Senha" type="password" required class="formInput formTextInput">
            </label>
            <div class="butao">
                <input class="btn" value="IR" id="btnVerMais" type="submit">
            </div>
        </div>

    </form>
</div>


<style>
    body {
        background-color: white;
    }

    input[type=text], input[type=password] {
        width: 70%;
        padding: 12px 20px;
        display: block;
        border: 1px solid black;
        box-sizing: border-box;
        margin: 0 0 0 3em;
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

    div.dados{
        margin: 2em;
    }

    div.butao {
        background: black;
        width: 3em;
        height: 3em;
        border-radius: 25px;
        text-align: center;
        margin: 5em 0 0 13em;
    }

    .formLabel {
        margin: 0 0 0 2em;
    }

    button:hover {
        opacity: 0.8;
    }

    .container {
        border: 1px solid black;
        width: 20em;
        height: 20em;
        background: white;
        display: block;
        margin: 8em 0 0 30em;
    }
</style>
</body>
</html>
