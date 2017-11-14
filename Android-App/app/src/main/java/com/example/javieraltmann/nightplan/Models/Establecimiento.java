package com.example.javieraltmann.nightplan.Models;

import android.content.Context;

/**
 * Created by Caro on 4/11/2017.
 */

public class Establecimiento {

    private int idEstablecimiento;
    private String name;
    private String address;
    private String barrio;
    private String phone;
    private int destacado;
    private int image;
    private Context context;

    public Establecimiento(int idEstablecimiento, String name, String address, String barrio, String phone, int destacado, int image, Context context) {
        this.idEstablecimiento = idEstablecimiento;
        this.name = name;
        this.address = address;
        this.barrio = barrio;
        this.phone = phone;
        this.destacado = destacado;
        this.image = image;
        this.context = context;
    }

    public Establecimiento(Context context,int idEstablecimiento, int image, String name,String barrio, int destacado){
        this.idEstablecimiento = idEstablecimiento;
        this.name = name;
        this.image = image;
        this.context = context;
        this.barrio = barrio;
        this.destacado = destacado;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(int idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int isDestacado() {
        return destacado;
    }

    public void setDestacado(int destacado) {
        this.destacado = destacado;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
