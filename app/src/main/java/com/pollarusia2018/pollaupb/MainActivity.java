package com.pollarusia2018.pollaupb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ImageButton apuestasButton;
    private ImageButton amigosButton;
    private ImageButton partidosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        apuestasButton = findViewById(R.id.apuestasButton);
        amigosButton = findViewById(R.id.amigosButton);
        partidosButton = findViewById(R.id.partidosButton);

        apuestasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apuestas= new Intent(context,ApuestasActivity.class);
                startActivity(apuestas);
            }
        });

        amigosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent amigos= new Intent(context,AmigosActivity.class);
                amigos.putExtra("quien","Diego");
                startActivity(amigos);
            }
        });

        partidosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent partidos= new Intent(context,PartidosActivity.class);
                startActivity(partidos);
            }
        });
    }
}
