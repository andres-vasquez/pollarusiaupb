package com.pollarusia2018.pollaupb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportMenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenuActivity extends AppCompatActivity {

    private Context context;

    private ImageButton apuestasButton;
    private ImageButton amigosButton;
    private ImageButton partidosButton;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        context = this;

        apuestasButton = findViewById(R.id.apuestasButton);
        amigosButton = findViewById(R.id.amigosButton);
        partidosButton = findViewById(R.id.partidosButton);

        apuestasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apuestas = new Intent(context, ApuestasActivity.class);
                startActivity(apuestas);
            }
        });

        amigosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent amigos = new Intent(context, AmigosActivity.class);
                amigos.putExtra("quien", "Diego");
                startActivity(amigos);
            }
        });

        partidosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent partidos = new Intent(context, PartidosActivity.class);
                startActivity(partidos);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        verifyUser();

    }

    public void verifyUser() {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser == null) {
            goLogInScreen();
        }
    }

    private void goLogInScreen() {
        Intent i = new Intent(this, LogInActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.profileItem){
            goProfileScreen();
        }

        return super.onOptionsItemSelected(item);
    }

    private void goProfileScreen() {
        Intent i = new Intent(this, PerfilActivity.class);
        startActivity(i);
    }

    public void logOut(View view) {
        firebaseAuth.signOut();

    }
}
