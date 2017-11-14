package com.example.javieraltmann.nightplan.Services;

import com.example.javieraltmann.nightplan.Models.Grupo;
import com.example.javieraltmann.nightplan.Models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by javier.altmann on 12/11/2017.
 */

public interface GrupoClient {


    @GET("API/grupos")
    void getGrupos(Callback<List<Grupo>> callback);

    @POST("grupo/nuevo")
    Call<Usuario> crearGrupo(@Body Grupo group);
}
