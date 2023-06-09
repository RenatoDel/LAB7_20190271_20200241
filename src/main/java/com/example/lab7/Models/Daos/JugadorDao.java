package com.example.lab7.Models.Daos;

import com.example.lab7.Models.Beans.Jugador;
import com.example.lab7.Models.Beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadorDao extends BaseDao{


    /**Lista jugadores**/
    public ArrayList<Jugador> listarJugador(){

        ArrayList<Jugador> lista = new ArrayList<>();
        String sql = "select * FROM jugador j inner join seleccion s on j.sn_idSeleccion = s.idSeleccion";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Jugador jugador = new Jugador();

                jugador.setIdJugador(resultSet.getInt(1));
                jugador.setNombre(resultSet.getString(2));
                jugador.setEdad(resultSet.getInt(3));
                jugador.setPosicion(resultSet.getString(4));
                jugador.setClub(resultSet.getString(5));

                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(resultSet.getInt(7));
                seleccion.setNombre(resultSet.getString(8));

                jugador.setSeleccion(seleccion);
                lista.add(jugador);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    /**Guardar form**/
    public void guardarJugador(Jugador jugador){
        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            /**Añadimos los parametros obtenidos desde el form**/
            pstmt.setString(1, jugador.getNombre());
            pstmt.setInt(2, jugador.getEdad());
            pstmt.setString(3, jugador.getPosicion());
            pstmt.setString(4, jugador.getClub());
            if (jugador.getSeleccion().getIdSeleccion() == 0) {
                pstmt.setNull(5, Types.INTEGER);
            } else {
                pstmt.setInt(5, jugador.getSeleccion().getIdSeleccion());
            }
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
