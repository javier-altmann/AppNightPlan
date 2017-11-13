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

public interface UsuarioServices {

    @GET("API/test")
    void getUsuario(Callback<List<Usuario>> callback);

    @POST("usuario/nuevo")
    Call<Usuario> createUser(@Body Usuario user);

}
