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
<div id="box">
    <form  action="atualizar" method="post">
    <input hidden name="id" value=<%=usuarioalterar.getId()%>>
        nome:
    <input name="nome" type="text" value=<%=usuarioalterar.getNome()%>>
        login
    <input name="login" type="text" value=<%=usuarioalterar.getLogin()%>>
        senha:
    <input name="senha" type="text" value=<%=usuarioalterar.getSenha()%>>
        email:
    <input name="email" type="email" value=<%=usuarioalterar.getEmail()%>>
    <input type="submit" value="Editar">
    </form>
    <form action="deletar" method="post">
        <input hidden name="id" value=<%=usuarioalterar.getId()%>>
        <input type="submit" value="deletar">
    </form>

</div>

</body>
</html>
