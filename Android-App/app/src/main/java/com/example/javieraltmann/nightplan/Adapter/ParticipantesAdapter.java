package com.example.javieraltmann.nightplan.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.javieraltmann.nightplan.Models.Usuario;
import com.example.javieraltmann.nightplan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ParticipantesAdapter extends BaseAdapter {

    Context context;
    List<Usuario> usuarioList;

    public ParticipantesAdapter(Context context, List<Usuario> usuarioList) {
        this.context = context;
        this.usuarioList = usuarioList;
    }

    @Override
    public int getCount() {
        return usuarioList.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarioList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return usuarioList.get(i).getId();
    }

    @Override
    public View getView(int i, View participantesView, ViewGroup viewGroup) {
        participantesView = LayoutInflater.from(context).inflate(R.layout.participantes_content, viewGroup, false);

        SimpleDraweeView draweeView = (SimpleDraweeView) participantesView.findViewById(R.id.imagen_participantes);


      final  Usuario usuarios = usuarioList.get(i);

        Uri uri = Uri.parse(usuarios.getImagenUsuario());
        draweeView.setImageURI(uri);

        return participantesView;


    }
}
