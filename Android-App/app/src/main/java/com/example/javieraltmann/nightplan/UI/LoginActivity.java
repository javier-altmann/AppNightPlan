package com.example.javieraltmann.nightplan.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javieraltmann.nightplan.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by javier.altmann on 3/11/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText userEt;
    private EditText passwordEt;
    private Button enterBtn;
    private TextView registrarteBtn;
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private Context context;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindUi();

        prefs = getSharedPreferences("Preferences",Context.MODE_PRIVATE);
        context = this;
        enterBtn = (Button) findViewById(R.id.enter_btn);
        registrarteBtn = (TextView) findViewById(R.id.registrarse);

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goToDestacados();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Cacenlo login",Toast.LENGTH_SHORT);
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),"Error login",Toast.LENGTH_SHORT);
            }
        });




        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userEt.getText().toString();
                String password = passwordEt.getText().toString();
                if(login(username,password)){
                    goToDestacados();
                    guardarPreferencias(username,password);
                }


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void bindUi(){
        userEt = (EditText) findViewById(R.id.username);
        passwordEt = (EditText) findViewById(R.id.password);

    }

    private boolean login(String username, String password){
        if(!validacionUsername(username)){
            Toast.makeText(this,"El usuario o contraseña es invalido, intente nuevamente",Toast.LENGTH_LONG).show();
            return false;
        }else if(!validacionPassword(password)){
            Toast.makeText(this,"El usuario o contraseña es invalido, intente nuevamente",Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
    private boolean  validacionUsername(String username){
        return !TextUtils.isEmpty(username);
    }

    private boolean validacionPassword(String password){
        return password.length() > 4;
    }

    private void goToDestacados(){
        Intent intent = new Intent(context,DestacadosActivity.class);
        //Uso el flag para que si vuelve para atrás se cierre la aplicación
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    private void guardarPreferencias(String username, String password){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();
    }

}