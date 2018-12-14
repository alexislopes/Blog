<%@ page import="javafx.geometry.Pos" %>
<%@ page import="modelo.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 11/12/2018
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@include file="cabecalho.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Postagem postagem = (Postagem) request.getAttribute("postagem");
    List<Comentario> comentarios = postagem.getComentarios();
    session.setAttribute("postagem", postagem);
    if (usuario == null) {
        usuario = new Usuario();
    }

%>


<html>
<head>
    <title>Postagem</title>
</head>
<body>

<div class="container">

    <div id="post">
        <h1 id="titulo"><%=postagem.getTitulo().toUpperCase()%>
        </h1>
        <h6 id="data"><%=postagem.getData()%>
        </h6>
        <p id="texto"><%=postagem.getTexto()%>
        </p>
    </div>

    <div id="comentar">
        <h1>Comentários:</h1>
        <%if (usuario.getId() != null) {%>
        <form id="tmj" action="comentar" method="post">

            <label class="formLabel">
                <input name="nomeUsuario" disabled value=<%=usuario.getNome()%>, type="text" required>
            </label>

            <label class="formLabel">
                <input name="comentario" placeholder="Comentário" type="text" required>
            </label>

            <label class="formLabel">
                <input name="idUsuario" hidden value=<%=usuario.getId()%>>
            </label>

            <label class="formLabel">
                <input name="idPostagem" hidden value=<%=postagem.getId()%>>
            </label>
            <div class="butao">
                <input class="btn" value="COM" id="btnVerMais2" type="submit">
            </div>

        </form>
        <%}%>


        <%
            if (!comentarios.isEmpty()) {
                for (Comentario comentario : comentarios) {
        %>
        <div id="comentario">
            <div id="autor">
                <h4><%=usuario.achaUsuarioPorId(comentario.getUsuario()).getNome() + " • " + comentario.getData() %>
                </h4>
                <div id="conteudo">
                    <h3><%=comentario.getConteudo()%>
                    </h3>
                </div>
            </div>
            <%if(eadmin) {
                System.out.println("eadmin?: " + eadmin);%>
            <form id="top" action="delcom" method="post">
                <input hidden name="comid" value=<%=comentario.getId()%>>
                <div class="butao">
                    <input class="btn" value="DEL" id="btnVerMais" type="submit">
                </div>
            </form>
            <%}%>
        </div>

        <%}%>
        <%} else { %>
        <h2>Lista de comentários vazia!</h2>
        <%}%>
    </div>

</div>


<style>
    body {
        background-color: white;
    }

    .container {
        width: 100%;
        height: 100%;
        background: white;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;

    }

    form#tmj {
        display: inline-block;
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

    div.dados{
        margin: 2em;
    }

    input[type=text], input[type=password] {
        background: transparent;
        width: 40%;
        padding: 12px 20px;
        display: inline-block;
        border: 1px solid black;
        box-sizing: border-box;
        margin: 0 0 0 1em;
    }

    div.butao {
        background: black;
        width: 3em;
        height: 3em;
        border-radius: 30px;
        text-align: center;
        margin: 0 0 0 28em;
    }

    #post {
        width: 50%;
        height: 100%;
        text-align: center;
    }

    h1 {
        background-color: black;
        color: white;
        margin: 1em;
    }

    p {
        margin: 20px;
        text-align: justify;
        font-size: 24px;
    }

    #comentar {
        text-align: center;
        width: 50%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.3);
        display: inline-block;
        flex-direction: row;
        justify-content: center;
        align-items: center;
    }

    #comentario {
        text-align: justify;
        width: 80%;
        margin: 0 0 0 5em;
        border: 1px solid black;

    }

    #comentario h6 {
        margin: 2em 1em;

    }

    h3 {
        background-color: rgba(0, 0, 0, 0.3);
        padding: 0.5em;
    }

    h4 {
        margin: 1em 0 0 1em;
    }

    #comentario h3 {
        margin: 1em 3em;
    }


</style>

</body>
</html>
