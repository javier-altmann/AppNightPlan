package com.example.javieraltmann.nightplan.Services;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.example.javieraltmann.nightplan.Models.Destacados;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by javier.altmann on 17/11/2017.
 */

public class DestacadosClient {

    private static Context context;
    private static DestacadosApi client;


    public static void init(Context con) {

        context = con;
    }


    private static DestacadosApi getClient() {

        if(client == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/javier-altmann/api-mock/")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            client = retrofit.create(DestacadosApi.class);
        }
        return client;
    }


    public static void getDestacados(final OnSuccessCallback callback) {

        getClient().getDestacados().enqueue(new Callback<List<Destacados>>() {

            @Override
            public void onResponse(Call<List<Destacados>> call, Response<List<Destacados>> response) {
                callback.execute(response.body());
            }
            @Override
            public void onFailure(Call<List<Destacados>> call, Throwable throwable) {

               Toast.makeText(context, "Fallo al querer conectarse con el servidor", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        System.exit(0);
                    }
                }, 2000);
            }
        });
    }

}
