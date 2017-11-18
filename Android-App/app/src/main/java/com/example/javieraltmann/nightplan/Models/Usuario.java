package com.example.javieraltmann.nightplan.Models;

import android.content.Context;

/**
 * Created by Caro on 4/11/2017.
 */

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private Context context;

    public Usuario(String username, String password, String name, String lastName, String imagen, Context context) {
        this.username = username;
        this.password = password;
        this.nombre = name;
        this.apellido = lastName;
        this.context = context;
    }

    public Usuario(String username, String password, Context context) {
        this.username = username;
        this.password = password;
        this.context = context;

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

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}