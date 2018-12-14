<%--
  Created by IntelliJ IDEA.
  User: alexi
  Date: 06/10/2018
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.ArrayList" %>
<%@page import="modelo.Usuario" %>
<%@page import="modelo.Papel" %>
<%@page import="modelo.EnumPapeis" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean eadmin = false;
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

    if(usuario != null) {
        ArrayList<Papel> papeis = (ArrayList<Papel>) usuario.getPapeis();
        for (Papel papel : papeis) {
            if (papel.getDescricao().toString().equals("Administrador")) {
                eadmin = true;
            }
        }
    }
%>

</head>

<header>

    <%if (usuario == null) {%> <!-- VISITANTE -->
    <nav class="nav">
        <div class="acesso">
            <a href="paginainicial">CASA</a>
            <a href="login">ENTRAR</a>
            <a href="cadastrar">CADASTRAR-SE</a>
            <a>VISITANTE</a>
        </div>
    </nav>
    <%} else if(eadmin){%> <!-- logado como ADM -->
    <nav class="nav">
        <div class="acesso">
            <a href="paginainicial">CASA</a>
            <a href="escrever">ESCREVER</a>
            <a href="gerenciar">GERENCIAR</a>
            <a href="sair">SAIR</a>
            <a><%= usuario.getNome().toUpperCase()%></a>
        </div>
        <%} else {%> <!-- logado como USUARIO CADASTRADO -->
        <nav class="nav">
            <div class="acesso">
                <a href="paginainicial">CASA</a>
                <a href="sair">SAIR</a>
                <a><%= usuario.getNome().toUpperCase()%></a>
            </div>
            <%}%>
    </nav>


        <style>
            @font-face {
                font-family: RobotoBold;
                src: url("../fonts/RobotoCondensed-Bold.ttf");
            }

            body{
                padding: 0;
                margin: 0;
            }

            a{
                color: white;
                margin: 0 50px 50px 0;
            }

            .nav {
                font-family: RobotoBold;
                display: block;
                background-color: black;
                width: 100%;
                height: 3em;
                padding: 0;
                margin: 0;
            }

            a{
                text-decoration: none;
            }

            .acesso{
                font-size: 17px;
                display: inline-block;
                margin: 1.7em 0 0 5em;

            }
        </style>

</header>



</body>
</html>
