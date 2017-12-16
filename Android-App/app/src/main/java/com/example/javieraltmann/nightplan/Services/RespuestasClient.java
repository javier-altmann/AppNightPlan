package com.example.javieraltmann.nightplan.Services;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.example.javieraltmann.nightplan.Models.Destacados;
import com.example.javieraltmann.nightplan.Models.Respuestas;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Caro on 15/12/2017.
 */

public class RespuestasClient {

    private static Context context;
    private static AppNightPlanApi client;


    public static void init(Context con) {

        context = con;
    }


    private static AppNightPlanApi getClient() {

        if(client == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/javier-altmann/api-mock/")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            client = retrofit.create(AppNightPlanApi.class);
        }
        return client;
    }


    public static void getRespuestas(final OnSuccessCallback callback) {

        getClient().getRespuestas().enqueue(new Callback<List<Respuestas>>() {

            @Override
            public void onResponse(Call<List<Respuestas>> call, Response<List<Respuestas>> response) {
                callback.execute(response.body());
            }
            @Override
            public void onFailure(Call<List<Respuestas>> call, Throwable throwable) {

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
