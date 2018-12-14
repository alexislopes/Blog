<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 06/10/2018
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro</title>
    <link rel="stylesheet" type="text/css" href="${contexto}static/css/estilos.css">
</head>
<body>
<div class="container">
    <form class="baseForm" action="cadastro" method="post">
        <div class="dados">
            <label class="formLabel">
                <input name="nomeUsuario" placeholder="Nome" type="text" required class="formInput formTextInput">
            </label>

            <label class="formLabel">
                <input name="apelidoUsuario" placeholder="Login" type="text" required class="formInput formTextInput">
            </label>

            <label class="formLabel">
                <input name="emailUsuario" placeholder="Email" type=email required class="formInput formTextInput">
            </label>

            <label class="formLabel">
                <input name="senha" placeholder="Senha" type="password" required class="formInput formTextInput">
            </label>
            <div class="butao">
                <input class="btn" value="CAD" id="btnVerMais" type="submit">
            </div>
        </div>
    </form>
</div>

<style>
    body {
        background-color: white;
    }

    input[type=text], input[type=password], input[type=email] {
        width: 70%;
        padding: 12px 20px;
        display: block;
        border: 1px solid black;
        box-sizing: border-box;
        margin: 1em 0 0 5em;
    }


    .formLabel {
        margin: 0 0 0 2em;
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

    div.dados {
        margin: 2em;
    }

    div.butao {
        background: black;
        width: 3em;
        height: 3em;
        border-radius: 25px;
        text-align: center;
        margin: 1em 0 0 22em;
    }

    button:hover {
        opacity: 0.8;
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