package com.example.javieraltmann.nightplan.Services;

import com.example.javieraltmann.nightplan.Models.Establecimiento;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by javier.altmann on 12/11/2017.
 */

public interface DestacadosClient {

    @GET("API/lugares-destacados")
    void getEstablecimientos(Callback<List<Establecimiento>> callback);
}
