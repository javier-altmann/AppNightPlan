package com.example.javieraltmann.nightplan.Models;

/**
 * Created by javier.altmann on 23/11/2017.
 */

public class Recomendados {
    private int id;
    private String nombre;
    private String imagen;
    private String direccion;
    private String barrio;

    public Recomendados(int id, String nombre, String imagen, String direccion, String barrio) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.direccion = direccion;
        this.barrio = barrio;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
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
}
