<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lab7.Models.Beans.Jugador" %>
<jsp:useBean type="java.util.ArrayList<com.example.lab7.Models.Beans.Jugador>" scope="request" id="listaJugadores"/>

<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Fulbo"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="selecciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Bienvenido, lista de selecciones:</h1>
                </div>
                <div>
                    <a href="<%=request.getContextPath()%>/JugadorServlet?a=nuevo" class="btn btn-danger">Registrar Selección</a>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>TÉCNICO</th>
                            <th>ESTADIO</th>
                            <th>PRIMER PARTIDO</th>
                            <th>SELECCIÓN</th>
                        </tr>
                    </thead>

                    <tbody>

                    <% for (Jugador j : listaJugadores) { %>
                    <tr>
                        <td><%=j.getIdJugador()%></td>
                        <td><%=j.getNombre()%></td>
                        <td><%=j.getEdad()%></td>
                        <td><%=j.getPosicion()%></td>
                        <td><%=j.getClub()%></td>
                        <td><%=j.getSeleccion().getNombre()%></td>
                    </tr>
                    <% } %>

                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
