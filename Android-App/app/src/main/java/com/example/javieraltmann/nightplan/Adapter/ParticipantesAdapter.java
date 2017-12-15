package com.example.javieraltmann.nightplan.Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.javieraltmann.nightplan.Models.Recomendados;
import com.example.javieraltmann.nightplan.Models.Respuestas;
import com.example.javieraltmann.nightplan.Models.Usuario;
import com.example.javieraltmann.nightplan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ParticipantesAdapter extends RecyclerView.Adapter<ParticipantesAdapter.PartcipanteViewHolder> {

    Context context;
    List<Usuario> usuarioList;
    List<Respuestas> respuestasList;

    public ParticipantesAdapter(Context context,  List<Usuario> usuarioList,List<Respuestas>respuestasList) {
        this.context = context;
        this.usuarioList = usuarioList;
        this.respuestasList = respuestasList;
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


         /*  if(respuestasList.get(position).getIdRespuestasEncuesta().contains(respuestasList.get(position).getId())){
               Toast.makeText(context,"Ingreso en el if",Toast.LENGTH_LONG);
            }

            else{
               Toast.makeText(context,"Ingreso en el else",Toast.LENGTH_LONG);
            }
*/



        holder.imagen.setImageURI(Uri.parse(usuarioList.get(position).getImagenUsuario()));
       // holder.username.setText(usuarioList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }



}

