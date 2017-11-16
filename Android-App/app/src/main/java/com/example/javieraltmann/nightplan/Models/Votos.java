package com.example.javieraltmann.nightplan.Models;

/**
 * Created by javier.altmann on 5/11/2017.
 */

public class Votos {

    private String nombreDelLugar;
    private int cantidadVotos;

    public Votos(String nombreDelLugar, int cantidadVotos){
        this.nombreDelLugar = nombreDelLugar;
        this.cantidadVotos = cantidadVotos;
    }

    public void setNombreDelLugar(String nombreDelLugar) {
        this.nombreDelLugar = nombreDelLugar;
    }

    public String getNombreDelLugar() {
        return nombreDelLugar;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }
}
