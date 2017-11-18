package com.example.javieraltmann.nightplan.Services;

import android.content.Context;

/**
 * Created by javier.altmann on 17/11/2017.
 */

public class DestacadosClient {

    private static Context context;
    private static DestacadosClient client;

    //Necesario inicializar el contexto para usar esta clase
    public static void init(Context con) {
        context = con;
    }

}
