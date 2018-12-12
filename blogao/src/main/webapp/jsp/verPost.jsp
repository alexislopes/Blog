<%@ page import="javafx.geometry.Pos" %>
<%@ page import="modelo.*" %><%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 11/12/2018
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Postagem postagem = (Postagem) request.getAttribute("postagem");

%>

<%@include file="cabecalho.jsp" %>
<html>
<head>
    <title>Postagem</title>
</head>
<body>

<div id="post">
    <h1 id="titulo"><%=postagem.getTitulo()%>
    </h1>
    <h6 id="data"><%=postagem.getData()%>
    </h6>
    <p id="texto"><%=postagem.getTexto()%>
    </p>
</div>

<div>
    <h1>Comentários</h1>
    <%if (usuario != null) {%>
    <form action="comentar" method="post">

        <label class="formLabel">
            Nome:
            <input name="nomeUsuario" value=<%=usuario.getNome()%>, type="text" required>
        </label>

        <label class="formLabel">
            Comentário:
            <input name="comentario" type="text" required>
        </label>

        <label class="formLabel">
            <input name="idUsuario" hidden value=<%=usuario.getId()%>>
        </label>

        <label class="formLabel">
            <input name="idPostagem" hidden value=<%=postagem.getId()%>>
        </label>


    </form>
    <%}%>
</div>

<%
    if (!postagem.getComentarios().isEmpty()) {
        for (Comentario comentario : postagem.getComentarios()) {
%>
<div id="comentario">
    <label id="autor">
        <h2><%=usuario.achaUsuarioPorId(comentario.getUsuario())%>
        </h2>
        <label id="conteudo">
            <h3><%=comentario.getConteudo()%>
            </h3>
        </label>
        <h4><%=comentario.getData()%>
        </h4>
    </label>
</div>
<%}%>
<%} else { %>
<h2>Não há comentários para esta psotagem</h2>
<%}%>

</body>
</html>
