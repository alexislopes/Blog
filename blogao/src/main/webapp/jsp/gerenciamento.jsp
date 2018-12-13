<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 12/12/2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="cabecalho.jsp"%>
<%List<Usuario> usuarios = usuario.achaTodos();%>
<html>
<head>
    <title>Gerenciar</title>
</head>
<body>
<div id="usuarios">
    <%for(Usuario usuario1 : usuarios){%>
    <div id="usuario">
        <form action="editar">
            <input name="usuarioId" hidden value=<%=usuario1.getId()%>>
            <h1><%=usuario1.getNome()%></h1>
            <input type="submit" value="Editar">
        </form>
    </div>
    <%}%>
</div>

</body>
</html>
