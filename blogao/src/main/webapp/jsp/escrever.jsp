<%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 06/10/2018
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp"%>
<html>
<head>
    <title>Escrever Postagem</title>
</head>
<body>
<form class="baseForm" action="postar" method="post">
    <label class="formLabel" id="titulo">
        Titulo:
        <input name="titulo" type="text" required class="formInput formTextInput">
    </label>

    <label class="formLabel"l id="texto">
        Texto:
        <input name="texto" type="text" required class="formInput formTextInput">
    </label>


    <input type="submit" value="Postar" class="submitButton">
</form>

</body>
</html>
