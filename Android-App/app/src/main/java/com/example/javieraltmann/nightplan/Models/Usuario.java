package com.example.javieraltmann.nightplan.Models;

import android.content.Context;

/**
 * Created by Caro on 4/11/2017.
 */

public class Usuario {
    private String username;
    private String password;
    private String name;
    private String lastName;
    private int age;
    private String birthDate;
    private String imagen;
    private Context context;

    public Usuario(String username, String password, String name, String lastName, int age, String birthDate, String imagen, Context context) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.imagen = imagen;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}