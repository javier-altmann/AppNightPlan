package com.example.javieraltmann.nightplan.Models;

/**
 * Created by Caro on 4/11/2017.
 */

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String imagenUsuario;


    public Usuario(String username, String password, String name, String lastName, String imagenUsuario) {
        this.username = username;
        this.password = password;
        this.nombre = name;
        this.apellido = lastName;
        this.imagenUsuario = imagenUsuario;

    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }
}