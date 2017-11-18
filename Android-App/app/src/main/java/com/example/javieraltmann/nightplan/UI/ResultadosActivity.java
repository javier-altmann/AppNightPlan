package com.example.javieraltmann.nightplan.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.javieraltmann.nightplan.R;

/**
 * Created by javier.altmann on 17/11/2017.
 */

public class ResultadosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_grupo_resultados);

        RecyclerView participantesRv = (RecyclerView) findViewById(R.id.participantes_rv);
        RecyclerView recomendacionesRv = (RecyclerView) findViewById(R.id.rcomendaciones_rv);

        participantesRv.setLayoutManager(new LinearLayoutManager(this));
        recomendacionesRv.setLayoutManager(new LinearLayoutManager(this));



    }

}
