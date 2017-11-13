package com.example.javieraltmann.nightplan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by javier.altmann on 12/11/2017.
 */

public interface PreferenciasServices {

    @GET("API/chat/id")
    void getStatusUsuarios(Callback<List<Establecimiento>> callback);

    @GET("API/chat/id")
    void getLugaresRecomendados(Callback<List<Establecimiento>> callback);


    @POST("test")
    Call<Usuario> setPreferencias(@Body Establecimiento remplazarPropiedad);


}
