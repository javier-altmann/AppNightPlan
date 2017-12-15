package com.example.javieraltmann.nightplan.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.javieraltmann.nightplan.Adapter.ParticipantesAdapter;
import com.example.javieraltmann.nightplan.Adapter.ViewPagerAdapter;
import com.example.javieraltmann.nightplan.Models.Recomendados;
import com.example.javieraltmann.nightplan.Models.Respuestas;
import com.example.javieraltmann.nightplan.Models.Usuario;
import com.example.javieraltmann.nightplan.Persistencia;
import com.example.javieraltmann.nightplan.R;
import com.example.javieraltmann.nightplan.Services.OnSuccessCallback;
import com.example.javieraltmann.nightplan.Services.RecomendadosClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Created by javier.altmann on 28/11/2017.
 */

public class GrupoDestacadosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
 {
     private SharedPreferences prefs;
     ViewPager viewPager;
     LinearLayout sliderDotspanel;
     private int dotscount;
     private ImageView[] dots;




     RecyclerView recyclerView ;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_grupo_preferencias);
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

         Bundle arguments = getIntent().getExtras();
         String usuariosStr = arguments.getString("usuarios");
         List<Usuario> usuarios =  Arrays.asList(new Gson().fromJson(usuariosStr, Usuario[].class));


           String respuestaSerializado = arguments.getString("respuestas");
           List<Respuestas> respuestas = Arrays.asList(new Gson().fromJson(respuestaSerializado, Respuestas[].class));


         recyclerView = (RecyclerView) findViewById(R.id.participantes_rv);
         recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
         recyclerView.setAdapter(new ParticipantesAdapter(this, usuarios,respuestas));



         // ACA EMPIEZA EL SLIDESHOW
         viewPager = (ViewPager) findViewById(R.id.viewPager);

         sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);


         RecomendadosClient.getRecomendados(new OnSuccessCallback() {
             @Override
             public void execute(Object body) {
                 ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getBaseContext(),(List<Recomendados>) body);

                 viewPager.setAdapter(viewPagerAdapter);

             }
         });

         // ACA EMPIEZA LOS PUNTITOS DE ABAJO DEL SLIDESHOW
         dotscount = 4;
         dots = new ImageView[dotscount];


         for (int i = 0; i < dotscount; i++){

             dots[i] = new ImageView(this);
             dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

             LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

             params.setMargins(8, 0, 8, 0);

             sliderDotspanel.addView(dots[i], params);

         }

         dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {

                 for(int i = 0; i< dotscount; i++){
                     dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                 }

                 dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });





         ImageView preferenciasIv = (ImageView) findViewById(R.id.prefencias_iv);
         preferenciasIv.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(GrupoDestacadosActivity.this, CategoriasActivity.class);
                 startActivity(intent);
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
