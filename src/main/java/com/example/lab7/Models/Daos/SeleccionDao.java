package com.example.lab7.Models.Daos;

import com.example.lab7.Models.Beans.Estadio;
import com.example.lab7.Models.Beans.Jugador;
import com.example.lab7.Models.Beans.Partido;
import com.example.lab7.Models.Beans.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao{

    /**Listar selecciones**/
    public ArrayList<Seleccion> listarSeleccion(){

        ArrayList<Seleccion> lista = new ArrayList<>();
        String sql = "select * FROM seleccion";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(resultSet.getInt(1));
                seleccion.setNombre(resultSet.getString(2));
                seleccion.setTecnico(resultSet.getString(3));
                seleccion.setIdSeleccion(resultSet.getInt(4));
                lista.add(seleccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public ArrayList<Seleccion> listarPartido(){
        ArrayList<Seleccion> lista1 = new ArrayList<>();
        String sql = "SELECT *, e.nombre AS estadio, p.fecha AS primer_partido\n" +
                "FROM seleccion s\n" +
                "INNER JOIN estadio e ON s.estadio_idEstadio = e.idEstadio\n" +
                "INNER JOIN partido p ON (p.seleccionLocal = s.idSeleccion)\n" +
                "order by primer_partido";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while(resultSet.next()){
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(resultSet.getInt(1));
                seleccion.setNombre(resultSet.getString(2));
                seleccion.setTecnico(resultSet.getString(3));

                Estadio estadio = new Estadio();
                estadio.setIdEstadio(resultSet.getInt(5));
                estadio.setNombre(resultSet.getString(6));
                seleccion.setEstadio(estadio);

                Partido partido = new Partido();
                partido.setIdPartido(resultSet.getInt(9));
                partido.setSeleccionLocal(resultSet.getInt(10));
                partido.setSeleccionVisitante(resultSet.getInt(11));
                /**Falta completar un atributo para Partido**/

                lista1.add(seleccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista1;
    }
}
