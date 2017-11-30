package com.example.javieraltmann.nightplan.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.javieraltmann.nightplan.Adapter.ParticipantesAdapter;
import com.example.javieraltmann.nightplan.Models.Usuario;
import com.example.javieraltmann.nightplan.R;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by javier.altmann on 28/11/2017.
 */

public class CategoriasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
 {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_categorias);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                 this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
         drawer.addDrawerListener(toggle);
         toggle.syncState();

         NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);
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
             Intent intent = new Intent(getBaseContext(), LoginActivity.class);
             this.startActivity(intent);
         }

         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         drawer.closeDrawer(GravityCompat.START);
         return true;
     }
}
