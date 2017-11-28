package com.example.javieraltmann.nightplan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.javieraltmann.nightplan.Models.Grupo;
import com.example.javieraltmann.nightplan.R;
import com.example.javieraltmann.nightplan.UI.GrupoDestacadosActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Javier on 28/11/2017.
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
        return grupoList.get(i).getId();
    }

    @Override
    public View getView(int i, View grupoView, ViewGroup viewGroup) {
        grupoView = LayoutInflater.from(context).inflate(R.layout.grupos_content, viewGroup, false);

        SimpleDraweeView draweeView = (SimpleDraweeView) grupoView.findViewById(R.id.foto);
        TextView nombreTv = (TextView) grupoView.findViewById(R.id.nombre_grupo);
        TextView fechaTv = (TextView) grupoView.findViewById(R.id.fecha_grupo);

        final Grupo grupo = grupoList.get(i);




        Uri uri = Uri.parse(grupo.getFotoDelGrupo());
        draweeView.setImageURI(uri);
        nombreTv.setText(grupo.getNombreDelGrupo());
        fechaTv.setText(grupo.getFecha());



        grupoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GrupoDestacadosActivity.class);
                intent.putExtra("usuarios", new Gson().toJson(grupo.getUsuariosList()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return grupoView;
    }
}
