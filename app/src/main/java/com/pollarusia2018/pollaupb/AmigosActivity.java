package com.pollarusia2018.pollaupb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresvasquez on 11/24/17.
 */

public class AmigosActivity extends AppCompatActivity{

    private Context context;
    private List<Amigo> lstAmigos;
    private AmigoAdapter adapter;
    private RecyclerView amigosRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);
        context = this;

        amigosRecyclerView = findViewById(R.id.amigosRecyclerView);
        
        Intent mensaje = getIntent();
        if(mensaje.hasExtra("quien")){
            String quien = mensaje.getStringExtra("quien");
            Toast.makeText(context,quien,Toast.LENGTH_SHORT).show();
        }

        llenarAmigos();
        adapter = new AmigoAdapter(context,lstAmigos);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        amigosRecyclerView.setLayoutManager(linearLayoutManager);

        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
        amigosRecyclerView.setLayoutManager(gridLayoutManager);*/

        amigosRecyclerView.setAdapter(adapter);

    }

    private void llenarAmigos() {
        lstAmigos = new ArrayList<>();
        lstAmigos.add(new Amigo("Ale Cuentas",R.drawable.ale_cuentas));
        lstAmigos.add(new Amigo("Anita Aramburo",R.drawable.anita_aramburo));
        lstAmigos.add(new Amigo("Constanza Salinas",R.drawable.constanza_salinas));
        lstAmigos.add(new Amigo("Diego Maldonado",R.drawable.diego_maldonado));
    }
}
