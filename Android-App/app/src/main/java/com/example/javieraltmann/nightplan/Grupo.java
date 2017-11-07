package com.example.javieraltmann.nightplan;

import android.content.Context;

/**
 * Created by Caro on 4/11/2017.
 */

public class Grupo {
    private int idGroup;
    private String name;
    private Usuario participantesDelGrupo;
    private String fechaDeCreacion;
    private Context context;

    public Grupo(int idGroup, String name, Usuario participantesDelGrupo, String fechaDeCreacion, Context context) {
        this.idGroup = idGroup;
        this.name = name;
        this.participantesDelGrupo = participantesDelGrupo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.context = context;
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
