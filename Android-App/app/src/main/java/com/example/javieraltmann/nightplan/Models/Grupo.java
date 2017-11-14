package com.example.javieraltmann.nightplan.Models;

import android.content.Context;

/**
 * Created by Caro on 4/11/2017.
 */

public class Grupo {
    private int idGroup;
    private String name;
    private Usuario participantesDelGrupo;
    private String fechaDeCreacion;
    private int foto;
    private Context context;

    public Grupo(Context context , int idGroup, String name, Usuario participantesDelGrupo, String fechaDeCreacion) {
        this.idGroup = idGroup;
        this.name = name;
        this.participantesDelGrupo = participantesDelGrupo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.context = context;
    }

    public Grupo(Context context, int idGroup, String name, int foto, String fechaDeCreacion){
        this.idGroup = idGroup;
        this.name = name;
        this.foto = foto;
        this.fechaDeCreacion = fechaDeCreacion;
        this.context = context;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Usuario getParticipantesDelGrupo() {
        return participantesDelGrupo;
    }

    public void setParticipantesDelGrupo(Usuario participantesDelGrupo) {
        this.participantesDelGrupo = participantesDelGrupo;
    }


    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
