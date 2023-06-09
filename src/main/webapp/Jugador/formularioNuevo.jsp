<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--Importamos los Beans-->
<%@ page import="com.example.lab7.Models.Beans.Jugador" %>
<%@ page import="com.example.lab7.Models.Beans.Seleccion" %>

<!--Importamos las listas-->
<jsp:useBean id="listaJugadores" type="java.util.ArrayList<com.example.lab7.Models.Beans.Jugador>" scope="request"/>
<jsp:useBean id="listaSelecciones" type="java.util.ArrayList<com.example.lab7.Models.Beans.Seleccion>" scope="request"/>

<html>
<!--Colocar como value: nombre de la presente página -->
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Fulbo"/>
</jsp:include>
<body>
<div class='container'>
  <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value=""/>
  </jsp:include>

  <form method="POST" action="<%=request.getContextPath()%>/JugadorServlet" class="col-md-6 col-lg-6 text-light">
    <h1 class='mb-3'>Nuevo jugador</h1>
    <hr>
    <div class="mb-3">
      <label for="nombre">Nombre</label>
      <input type="text" class="form-control form-control-sm" name="nombre" id="nombre">
    </div>

    <div class="mb-3">
      <label for="edad">Edad</label>
      <input type="text" class="form-control form-control-sm" name="edad" id="edad">
    </div>

    <div class="mb-3">
      <label for="posicion">Posicion</label>
      <input type="text" class="form-control form-control-sm" name="posicion" id="posicion">
    </div>

    <div class="mb-3">
      <label for="club">Club</label>
      <input type="text" class="form-control form-control-sm" name="club" id="club">
    </div>



    <div class="mb-3">
      <label for="idSeleccion">Selección</label>
      <select class="form-select" name="idSeleccion">
        <option value="0">--Nacionalidad--</option>
        <% for (Seleccion seleccion : listaSelecciones) { %>
        <option value="<%=seleccion.getIdSeleccion() %>">
          <%=seleccion.getNombre()%>
        </option>
        <% } %>
      </select>
    </div>

    <a href="<%= request.getContextPath()%>/JugadorServlet" class="btn btn-danger">Cancelar</a>
    <button type="submit" class="btn btn-primary">Registrar</button>
  </form>



</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
