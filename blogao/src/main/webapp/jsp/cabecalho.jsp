<%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 06/10/2018
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@page import="modelo.Usuario" %>
<%@page import="modelo.Papel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Usuario usuario = (Usuario) request.getAttribute("usuarioLogado");%>

    <link rel="stylesheet" type="text/css" href="../css/estiloCabecalho.css">
</head>

<header>

    <%if (usuario == null) {%>
    <nav class="nav">
        <div class="acesso">
            <a href="login">ENTRAR</a>
            <a href="cadastrar">CADASTRAR-SE</a>
            <a>VISITANTE</a>
        </div>
    </nav>
    <%} else {%>
    <nav class="nav">
        <div class="acesso">
            <a href="escrever">ESCREVER</a>
            <a href="gerenciar">GERENCIAR</a>
            <a href="cadastrar">CADASTRAR-SE</a>
            <a><%= usuario.getNome()%></a>
        </div>
        <%}%>
    </nav>

</header>



</body>
</html>
