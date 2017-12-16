package com.example.javieraltmann.nightplan.Services;

import com.example.javieraltmann.nightplan.Models.Destacados;
import com.example.javieraltmann.nightplan.Models.Establecimiento;
import com.example.javieraltmann.nightplan.Models.Grupo;
import com.example.javieraltmann.nightplan.Models.Recomendados;
import com.example.javieraltmann.nightplan.Models.Respuestas;
import com.example.javieraltmann.nightplan.Models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Caro on 16/12/2017.
 */

public interface AppNightPlanApi {
    @GET("lugares-destacados")
    public Call<List<Destacados>> getDestacados();

    @GET("grupos")
    public Call<List<Grupo>> getGrupos();

    @POST("grupo/nuevo")
    Call<Usuario> crearGrupo(@Body Grupo group);

    @GET("API/chat/id")
    void getStatusUsuarios(Callback<List<Establecimiento>> callback);

    @GET("API/recomendados/id")
    void getLugaresRecomendados(Callback<List<Establecimiento>> callback);


    @POST("test")
    Call<Usuario> setPreferencias(@Body Establecimiento remplazarPropiedad);


    @GET("recomendados")
    public Call<List<Recomendados>> getRecomendados();

    @GET("respuestas-encuestas")
    public Call<List<Respuestas>> getRespuestas();

    @GET("usuarios") //Verbo HTTP y nombre del metodo de la API
    public Call<List<Usuario>> getUsuarios(); //El return type define como sera parseado automaticamente el response

    @POST("usuario/nuevo")
    Call<Usuario> createUser(@Body Usuario user);
}
