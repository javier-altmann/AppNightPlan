package com.example.javieraltmann.nightplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by javier.altmann on 2/12/2017.
 */

public class Persistencia {

    public void logout(Activity activity, Class clase){
        Intent intent = new Intent(activity,clase);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }

    public void resetearSharedPreferences(SharedPreferences prefs){
        prefs.edit().clear().apply();
    }
}
