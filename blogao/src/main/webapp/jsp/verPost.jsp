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
    if(usuario == null){
        usuario = new Usuario();
    }

%>


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
    <%if (usuario.getId() != null) {%>
    <form action="comentar" method="post">

        <label class="formLabel">
            Nome:
            <input name="nomeUsuario" disabled value=<%=usuario.getNome()%>, type="text" required>
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
        <input type="submit" value="Comentar" class="submitButton">

    </form>
    <%}%>
</div>

<%if(!comentarios.isEmpty()) {
    for(Comentario comentario : comentarios) {%>
        <div id="comentario">
            <div id="autor">
                <h4><%=usuario.achaUsuarioPorId(comentario.getUsuario()).getNome()%></h4>
                <div id="conteudo">
                    <h3><%=comentario.getConteudo()%></h3>
                </div>
                <h6><%=comentario.getData()%></h6>
            </div>
        </div>

    <%}%>
<%} else { %>
<h1>Lista de comentários vazia!</h1>
<%}%>

</body>
</html>
