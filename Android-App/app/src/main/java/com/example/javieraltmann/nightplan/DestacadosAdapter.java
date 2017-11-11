package com.example.javieraltmann.nightplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by CRISTIAN RIVERA on 10/11/2017.
 */

public class DestacadosAdapter extends BaseAdapter {


    private Context context;
    private List<Establecimiento> destacadosList;

    public DestacadosAdapter(Context context, List<Establecimiento> destacadosList) {
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
        return destacadosList.get(i).getIdEstablecimiento();
    }

    @Override
    public View getView(int i, View destacadosView, ViewGroup viewGroup) {

        destacadosView = LayoutInflater.from(context).inflate(R.layout.destacados_content, viewGroup, false);

        ImageView fotoImg = (ImageView) destacadosView.findViewById(R.id.foto_establecimiento);
        TextView nombreTv = (TextView) destacadosView.findViewById(R.id.nombre_establecimiento);
        TextView barrioTv = (TextView) destacadosView.findViewById((R.id.barrio));
        ImageView destacadoImg = (ImageView) destacadosView.findViewById(R.id.destacado);

        Establecimiento destacados = destacadosList.get(i);

        fotoImg.setImageResource(destacados.getImage());
        nombreTv.setText(destacados.getName());
        barrioTv.setText(destacados.getBarrio());
        destacadoImg.setImageResource(destacados.isDestacado());



        return destacadosView;
    }
}
