package com.example.javieraltmann.nightplan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javieraltmann.nightplan.Models.Destacados;
import com.example.javieraltmann.nightplan.R;

import java.util.List;

/**
 * Created by CRISTIAN RIVERA on 10/11/2017.
 */

public class DestacadosAdapter extends BaseAdapter {


    private Context context;
    private List<Destacados> destacadosList;

    public DestacadosAdapter(Context context, List<Destacados> destacadosList) {
        this.destacadosList = destacadosList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return destacadosList.size();
    }

    @Override
    public Object getItem(int i) {
        return destacadosList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return destacadosList.get(i).getId();
    }

    @Override
    public View getView(int i, View destacadosView, ViewGroup viewGroup) {

        destacadosView = LayoutInflater.from(context).inflate(R.layout.destacados_content, viewGroup, false);

        ImageView fotoImg = (ImageView) destacadosView.findViewById(R.id.foto_establecimiento);
        TextView nombreTv = (TextView) destacadosView.findViewById(R.id.nombre_establecimiento);
        TextView barrioTv = (TextView) destacadosView.findViewById((R.id.barrio));


        Destacados destacados = destacadosList.get(i);

        fotoImg.setImageResource(destacados.getImagen());
        nombreTv.setText(destacados.getNombre());
        barrioTv.setText(destacados.getBarrio());




        return destacadosView;
    }
}
