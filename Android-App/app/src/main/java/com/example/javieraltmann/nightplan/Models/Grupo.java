package com.example.javieraltmann.nightplan.Models;

import java.util.List;

/**
 * Created by Caro on 4/11/2017.
 */

public class Grupo {
    private int id;
    private String nombreDelGrupo;
    private String fecha;
    private String fotoDelGrupo;
    private List<Usuario> usuariosList;


    public Grupo(int id, String nombreDelGrupo, String fecha, String fotoDelGrupo, List<Usuario> usuariosList) {
        this.id = id;
        this.nombreDelGrupo = nombreDelGrupo;
        this.fecha = fecha;
        this.fotoDelGrupo = fotoDelGrupo;
        this.usuariosList = usuariosList;

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

    public String getFotoDelGrupo() {
        return fotoDelGrupo;
    }

    public void setFotoDelGrupo(String fotoDelGrupo) {
        this.fotoDelGrupo = fotoDelGrupo;
    }

    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

}



