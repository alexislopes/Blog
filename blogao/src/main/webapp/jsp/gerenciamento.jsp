<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 12/12/2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp" %>
<%List<Usuario> usuarios = usuario.achaTodos();%>
<html>
<head>
    <title>Gerenciar</title>
</head>
<body>
<div id="usuarios">
    <%for (Usuario usuario1 : usuarios) {%>
    <div id="usuario">
        <form action="editar">
            <input name="usuarioId" hidden value=<%=usuario1.getId()%>>
            <h3><%=usuario1.getNome().toUpperCase()%></h3>
            <div class="butao">
                <input class="btn" value="EDIT" id="btnVerMais" type="submit">
            </div>

        </form>
    </div>
    <%}%>
</div>

<style>
    body {
        background-color: white;
    }

    #usuarios {
        width: 50%;
        height: 100%;
        background: white;
        display: block;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        position: center;
        margin: auto;
    }

    #usuario {
        display: inline-block;
        background-color: white;
        width: 20%;
        height: 10%;
        justify-content: center;
        border: 1px solid black;
        position: center;
        margin: 1em;
    }

    h3 {
        text-align: center;
        font-size: 10px;
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
        margin: 0 0 30em 2.7em;
    }

</style>

</body>
</html>
