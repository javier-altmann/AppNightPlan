package com.example.javieraltmann.nightplan.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caro on 15/12/2017.
 */


public class Respuestas implements Serializable{

    private int id;
    List<Usuario> usuariosList;
    List<Integer> idRespuestasEncuesta = new ArrayList<Integer>();

    public Respuestas(int id, List<Usuario> usuariosList, List<Integer> idRespuestasEncuesta) {
        this.id = id;
        this.usuariosList = usuariosList;
        this.idRespuestasEncuesta = idRespuestasEncuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public List<Integer> getIdRespuestasEncuesta() {
        return idRespuestasEncuesta;
    }

    public void setIdRespuestasEncuesta(List<Integer> idRespuestasEncuesta) {
        this.idRespuestasEncuesta = idRespuestasEncuesta;
    }
}