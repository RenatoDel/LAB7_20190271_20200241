package com.example.lab7.Models.Beans;

public class Seleccion {

    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private Estadio Estadio;

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public com.example.lab7.Models.Beans.Estadio getEstadio() {
        return Estadio;
    }

    public void setEstadio(com.example.lab7.Models.Beans.Estadio estadio) {
        Estadio = estadio;
    }
}
