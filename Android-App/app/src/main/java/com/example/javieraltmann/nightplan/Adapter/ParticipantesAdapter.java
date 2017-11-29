package com.example.javieraltmann.nightplan.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javieraltmann.nightplan.Models.Usuario;
import com.example.javieraltmann.nightplan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ParticipantesAdapter extends RecyclerView.Adapter<ParticipantesAdapter.PartcipanteViewHolder> {

    Context context;
    List<Usuario> usuarioList;

    public ParticipantesAdapter(Context context, List<Usuario> usuarioList) {
        this.context = context;
        this.usuarioList = usuarioList;
    }

    class PartcipanteViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView imagen;
      //  TextView username;

        public PartcipanteViewHolder(View itemView) {
            super(itemView);
            imagen = (SimpleDraweeView) itemView.findViewById(R.id.imagen_participantes);
         //   username = (TextView) itemView.findViewById(R.id.participantes_rv);
        }
    }


    @Override
    public PartcipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PartcipanteViewHolder(LayoutInflater.from(context).inflate(R.layout.participantes_content, parent, false));
    }

    @Override
    public void onBindViewHolder(PartcipanteViewHolder holder, int position) {
        holder.imagen.setImageURI(Uri.parse(usuarioList.get(position).getImagenUsuario()));
       // holder.username.setText(usuarioList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }



}
