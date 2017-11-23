package com.example.javieraltmann.nightplan.Services;

import com.example.javieraltmann.nightplan.Models.Destacados;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by javier.altmann on 12/11/2017.
 */

public interface DestacadosApi {

    @GET("destacados")
    public Call<List<Destacados>> getDestacados();

}
