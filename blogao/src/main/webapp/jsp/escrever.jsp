<%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 06/10/2018
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp" %>
<html>
<head>
    <title>Escrever Postagem</title>
</head>
<body>
<div class="container">
    <form class="baseForm" action="postar" method="post">
        <div class="dados">
            <label class="formLabel" id="titulo">
                <input name="titulo" placeholder="Título" type="text" required class="formInput formTextInput">
            </label>
            <label class="formLabel" id="texto">
                <input name="texto" placeholder="Texto" type="text" required class="formInput formTextInput">
            </label>
            <div class="butao">
                <input class="btn" value="POST" id="btnVerMais" type="submit">
            </div>
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
        margin: 2em 0 0 11em;
    }

    .container {
        border: 1px solid black;
        width: 30em;
        height: 15em;
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
