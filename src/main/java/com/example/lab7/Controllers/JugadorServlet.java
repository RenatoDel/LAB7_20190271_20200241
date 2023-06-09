package com.example.lab7.Controllers;

import com.example.lab7.Models.Beans.Jugador;
import com.example.lab7.Models.Beans.Seleccion;
import com.example.lab7.Models.Daos.JugadorDao;
import com.example.lab7.Models.Daos.SeleccionDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JugadorServlet", value = "/JugadorServlet")
public class JugadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        JugadorDao jugadorDao = new JugadorDao();
        SeleccionDao seleccionDao = new SeleccionDao();

        String action = request.getParameter("a") == null ? "listarJugadores" : request.getParameter("a");

        switch (action){

            case "listarJugadores":
                request.setAttribute("listaJugadores",jugadorDao.listarJugador());
                request.getRequestDispatcher("Jugador/jugador.jsp").forward(request,response);
                break;

            case "nuevo":
                request.setAttribute("listaJugadores",jugadorDao.listarJugador());
                request.setAttribute("listaSelecciones",seleccionDao.listarSeleccion());
                request.getRequestDispatcher("Jugador/formularioNuevo.jsp").forward(request,response);
                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("p") == null ? "guardar" : request.getParameter("a");

        JugadorDao jugadorDao = new JugadorDao();
        Jugador jugador = parseJugador(request);

        switch (action){

            case "guardar":
                jugadorDao.guardarJugador(jugador);
                response.sendRedirect("JugadorServlet");
                break;
        }


    }


    /**Creación del parseJugador --> objeto un jugador**/
    public Jugador parseJugador(HttpServletRequest request) {

        Jugador jugador = new Jugador();
        Seleccion seleccion = new Seleccion();

        /**Obtener los parametros del form y almacenarlos**/
        jugador.setNombre(request.getParameter("nombre"));
        jugador.setEdad(Integer.parseInt(request.getParameter("edad")));
        jugador.setPosicion(request.getParameter("posicion"));
        jugador.setClub(request.getParameter("club"));

        /**Ingresamos el parametro de la seleccion obtenida**/
        seleccion.setIdSeleccion(Integer.parseInt(request.getParameter("idSeleccion")));
        jugador.setSeleccion(seleccion);

        return jugador;
    }
}
