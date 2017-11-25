package com.example.javieraltmann.nightplan.Services;

import com.example.javieraltmann.nightplan.Models.Recomendados;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by javier.altmann on 23/11/2017.
 */

public interface RecomendadosApi {


    @GET("recomendados")
    public Call<List<Recomendados>> getRecomendados();

}
