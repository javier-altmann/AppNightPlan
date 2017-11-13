package com.example.javieraltmann.nightplan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by javier.altmann on 4/11/2017.
 */

public class RegistrarseActivity extends AppCompatActivity {

    private EditText userEt;
    private EditText passwordEt;
    private EditText nombreEt;
    private EditText apellidoEt;
    private EditText mailEt;
    private Button registrarseBtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);



        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,LoginActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
