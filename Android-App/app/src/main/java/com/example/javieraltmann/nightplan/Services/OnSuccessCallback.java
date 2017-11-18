package com.example.javieraltmann.nightplan.Services;

/**
 * Created by javier.altmann on 17/11/2017.
 */

public interface OnSuccessCallback {

    //Este metodo es el unico que se implementara, la idea es que como parametro entre la respuesta
    // del proceso asincronico quwe se realizo (en nuestro caso la llamada a la API)
    public void execute(Object body);

}
