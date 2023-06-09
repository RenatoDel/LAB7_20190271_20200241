package com.example.lab7.Models.Daos;

import com.example.lab7.Models.Beans.Jugador;
import com.example.lab7.Models.Beans.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao{

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

}
