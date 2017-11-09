package com.example.javieraltmann.nightplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Caro on 9/11/2017.
 */

public class GrupoAdapter extends BaseAdapter {

    private Context context;
    private List<Grupo> grupoList;

    public GrupoAdapter(Context context, List<Grupo> grupoList) {
        this.grupoList = grupoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return grupoList.size();
    }

    @Override
    public Object getItem(int i) {
        return grupoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return grupoList.get(i).getIdGroup();
    }

    @Override
    public View getView(int i, View grupoView, ViewGroup viewGroup) {
        grupoView = LayoutInflater.from(context).inflate(R.layout.grupos_content, viewGroup, false);

        ImageView fotoImg = (ImageView) grupoView.findViewById(R.id.foto);
        TextView nombreTv = (TextView) grupoView.findViewById(R.id.nombre_grupo);
        TextView fechaTv = (TextView) grupoView.findViewById(R.id.fecha_grupo);

        Grupo grupo = grupoList.get(i);

        fotoImg.setImageResource(grupo.getFoto());
        nombreTv.setText(grupo.getName());
        fechaTv.setText(grupo.getFechaDeCreacion());


        return grupoView;
    }
}
