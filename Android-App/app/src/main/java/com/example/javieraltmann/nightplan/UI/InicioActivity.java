package com.example.javieraltmann.nightplan.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.WindowManager;

import com.example.javieraltmann.nightplan.Models.Destacados;
import com.example.javieraltmann.nightplan.R;
import com.facebook.AccessToken;

public class InicioActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 500;
    private SharedPreferences prefs;
    private Intent intentLogin;
    private Intent intentDestacados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_inicio);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        intentLogin = new Intent(this,LoginActivity.class);
        intentDestacados = new Intent(this, DestacadosActivity.class);


        new Handler().postDelayed(new Runnable(){
            public void run(){


                if(!TextUtils.isEmpty(getUsernamePrefs()) || AccessToken.getCurrentAccessToken() != null ) {
                    startActivity(intentDestacados);
                }else{
                    startActivity(intentLogin);
                }
                finish();
            }
        }, DURACION_SPLASH);

    }



    private String getUsernamePrefs(){
        return  prefs.getString("username", "");

    }
}


