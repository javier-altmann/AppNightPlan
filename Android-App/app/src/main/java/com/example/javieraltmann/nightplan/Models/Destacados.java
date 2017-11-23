package com.example.javieraltmann.nightplan.Models;

/**
 * Created by javier.altmann on 17/11/2017.
 */

public class Destacados {

    private int id;
    private String nombre;
    private int imagen;
    private String direccion;
    private String barrio;
    private String destacado;

    public Destacados(int id, String nombre, int imagen, String direccion, String barrio, String destacado) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.direccion = direccion;
        this.barrio = barrio;
        this.destacado = destacado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDestacado() {
        return destacado;
    }

    public void setDestacado(String destacado) {
        this.destacado = destacado;
    }
}
