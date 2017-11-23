package com.example.javieraltmann.nightplan.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.javieraltmann.nightplan.Models.Grupo;
import com.example.javieraltmann.nightplan.ParseoJson;
import com.example.javieraltmann.nightplan.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by javier.altmann on 4/11/2017.
 */

public class GrupoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private List<Grupo> gruposList;
    private ParseoJson parse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // List<Grupo> grupoList = new ArrayList<>();
        /*
        grupoList.add(new Grupo(getBaseContext(), 1, "Boca", R.drawable.imagen2, "05-11-2017"));
        grupoList.add(new Grupo(getBaseContext(), 2, "River", R.drawable.imagen2, "06-11-2017"));
        grupoList.add(new Grupo(getBaseContext(), 3, "Racing", R.drawable.imagen2, "07-11-2017"));
        grupoList.add(new Grupo(getBaseContext(), 4, "Independiente", R.drawable.imagen2, "08-11-2017"));

        ListView grupoLv = (ListView) findViewById(R.id.crear_grupo_lv);
        grupoLv.setAdapter(new GrupoAdapter(getBaseContext(), grupoList));
        */

        /*
        UsuarioClient.getUsuarios(new OnSuccessCallback() {
            @Override
            public void execute(Object body) {
                //Lo que se debe hacer con la respuesta del servidor
                ListView pizzaLv = (ListView) findViewById(R.id.pizza_lv); //El listview
                //Le asigno el adapter, al cual le paso el contexto y la lista de pizzas que vino
                pizzaLv.setAdapter(new PizzaAdapter(getBaseContext(), (List<Pizza>) body));
                //Saco el Progress Dialog de la pantalla
                progressDialog.dismiss();
            }
        });
*/

        parse = new ParseoJson();
        System.out.println("Lectura Json terminada");
        String jsonString = parse.readMockJsonFile(this);
        gruposList = Arrays.asList(new Gson().fromJson(new Gson().fromJson(jsonString, JsonObject.class).get("grupos").toString(), Grupo[].class));
        return;
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

        }  else if (id == R.id.nav_cuenta) {


        } else if (id == R.id.nav_cerrar_sesion) {
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            this.startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
