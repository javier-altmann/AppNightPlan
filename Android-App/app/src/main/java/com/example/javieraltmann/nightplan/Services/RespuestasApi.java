package com.example.javieraltmann.nightplan.Services;

import com.example.javieraltmann.nightplan.Models.Recomendados;
import com.example.javieraltmann.nightplan.Models.Respuestas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Caro on 15/12/2017.
 */

interface RespuestasApi {
    @GET("respuestas-encuestas")
    public Call<List<Respuestas>> getRespuestas();
}
