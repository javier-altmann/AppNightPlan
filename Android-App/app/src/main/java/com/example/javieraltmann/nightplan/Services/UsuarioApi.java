package com.example.javieraltmann.nightplan.Services;

import com.example.javieraltmann.nightplan.Models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by javier.altmann on 12/11/2017.
 */

public interface UsuarioApi {

    @GET("usuarios") //Verbo HTTP y nombre del metodo de la API
    public Call<List<Usuario>> getUsuarios(); //El return type define como sera parseado automaticamente el response

    @POST("usuario/nuevo")
    Call<Usuario> createUser(@Body Usuario user);

}
