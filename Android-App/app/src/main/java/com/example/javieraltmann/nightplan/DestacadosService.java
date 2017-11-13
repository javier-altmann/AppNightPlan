package com.example.javieraltmann.nightplan;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by javier.altmann on 12/11/2017.
 */

public interface DestacadosService {

    @GET("API/test")
    void getEstablecimientos(Callback<List<Establecimiento>> callback);
}
