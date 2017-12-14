package com.example.javieraltmann.nightplan.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.javieraltmann.nightplan.Adapter.DestacadosAdapter;
import com.example.javieraltmann.nightplan.Models.Destacados;
import com.example.javieraltmann.nightplan.Persistencia;
import com.example.javieraltmann.nightplan.R;
import com.example.javieraltmann.nightplan.Services.DestacadosClient;
import com.example.javieraltmann.nightplan.Services.OnSuccessCallback;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JAVIER ALTMANN on 14/12/2017.
 */

public class DestacadosActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences prefs;
    private LoginButton loginButton;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_destacados);

            prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            loginButton = (LoginButton) findViewById(R.id.login_button);
            DestacadosClient.getDestacados(new OnSuccessCallback() {
                @Override
                public void execute(Object body) {

                    GridView destacadosGv = (GridView) findViewById(R.id.DestacadoGv);
                    destacadosGv.setAdapter(new DestacadosAdapter(getBaseContext(), (List<Destacados>) body));
                }
            });


        }


        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_inicio) {
                Intent intent = new Intent(getBaseContext(), DestacadosActivity.class);
                this.startActivity(intent);
            } else if (id == R.id.nav_mis_grupos) {
                Intent intent = new Intent(getBaseContext(), GrupoActivity.class);
                this.startActivity(intent);
            } else if (id == R.id.nav_cuenta) {

            } else if (id == R.id.nav_cerrar_sesion) {
                Persistencia p = new Persistencia();
                p.resetearSharedPreferences(prefs);
                p.logout(this,LoginActivity.class);
                p.logoutFacebook(this, LoginActivity.class);
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }


}
