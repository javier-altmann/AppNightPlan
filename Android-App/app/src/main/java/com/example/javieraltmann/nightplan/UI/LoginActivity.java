package com.example.javieraltmann.nightplan.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.javieraltmann.nightplan.R;

/**
 * Created by javier.altmann on 3/11/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText userEt;
    private EditText passwordEt;
    private Button enterBtn;
    private TextView registrarteBtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        context = this;
        userEt = (EditText) findViewById(R.id.username);
        passwordEt = (EditText) findViewById(R.id.password);
        enterBtn = (Button) findViewById(R.id.enter_btn);
        registrarteBtn = (TextView) findViewById(R.id.registrarse);


        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DestacadosActivity.class);
                context.startActivity(intent);
            }

        });

        registrarteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RegistrarseActivity.class);
                context.startActivity(intent);
            }
        });
    }


}