package com.example.javieraltmann.nightplan.Models;

import android.content.Context;

import java.util.List;

/**
 * Created by Caro on 4/11/2017.
 */

public class Grupo {
    private int id;
    private String nombreDelGrupo;
    private String fecha;
    private int fotoDelGrupo;
    private List<Usuario> usuariosList;
    private Context context;

    public Grupo(int id, String nombreDelGrupo, String fecha, int fotoDelGrupo, List<Usuario> usuariosList, Context context) {
        this.id = id;
        this.nombreDelGrupo = nombreDelGrupo;
        this.fecha = fecha;
        this.fotoDelGrupo = fotoDelGrupo;
        this.usuariosList = usuariosList;
        this.context = context;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDelGrupo() {
        return nombreDelGrupo;
    }

    public void setNombreDelGrupo(String nombreDelGrupo) {
        this.nombreDelGrupo = nombreDelGrupo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getFotoDelGrupo() {
        return fotoDelGrupo;
    }

    public void setFotoDelGrupo(int fotoDelGrupo) {
        this.fotoDelGrupo = fotoDelGrupo;
    }

    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}



