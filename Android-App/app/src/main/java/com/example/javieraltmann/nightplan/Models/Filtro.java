package com.example.javieraltmann.nightplan.Models;

/**
 * Created by javier.altmann on 5/11/2017.
 */

public class Filtro {

    private String nombreDelFiltro;
    private int cantidadVotos;

    public Filtro(String nombreDelFiltro, int cantidadVotos){

        this.nombreDelFiltro = nombreDelFiltro;
        this.cantidadVotos = cantidadVotos;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public void setNombreDelFiltro(String nombreDelFiltro) {
        this.nombreDelFiltro = nombreDelFiltro;
    }

    public String getNombreDelFiltro() {
        return nombreDelFiltro;
    }
}
