package com.example.javieraltmann.nightplan.Services;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.example.javieraltmann.nightplan.Models.Grupo;
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

public class GrupoClient {

    private static Context context;
    private static AppNightPlanApi client;

    //Necesario inicializar el contexto para usar esta clase
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


    public static void getGrupos(final OnSuccessCallback callback) {

        getClient().getGrupos().enqueue(new Callback<List<Grupo>>() {

            @Override
            public void onResponse(Call<List<Grupo>> call, Response<List<Grupo>> response) {
                callback.execute(response.body());
            }
            @Override
            public void onFailure(Call<List<Grupo>> call, Throwable throwable) {

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
