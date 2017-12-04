package com.pollarusia2018.pollaupb;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.pollarusia2018.pollaupb.adapters.CountriesAdapter;
import com.pollarusia2018.pollaupb.models.Country;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;

    private ImageView apuestasImageView;
    private ImageView amigosImageView;
    private ImageView partidosImageView;
    private ImageView ajustesImageView;
    private ImageView perfilImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //countriesRecyclerView = (RecyclerView) findViewById(R.id.countriesRecyclerView);
        //countriesRecyclerView.setHasFixedSize(true);
        //countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //countriesAdapter = new CountriesAdapter(this);
        //countriesRecyclerView.setAdapter(countriesAdapter);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        apuestasImageView = (ImageView) findViewById(R.id.apuestasImageView);
        amigosImageView = (ImageView) findViewById(R.id.amigosImageView);
        partidosImageView = (ImageView) findViewById(R.id.partidosImageView);
        ajustesImageView = (ImageView) findViewById(R.id.ajustesImageView);
        perfilImageView = (ImageView) findViewById(R.id.perfilImageView);

        apuestasImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("My App", "Go to Apuestas Screen");
            }
        });

        amigosImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("My App", "Go to Amigos Screen");
            }
        });

        partidosImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("My App", "Go to Partidos Screen");
            }
        });

        ajustesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("My App", "Go to Ajustes Screen");
            }
        });

        perfilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("My App", "Go to Perfil Screen");
            }
        });


        verifyUser();

    }

    public void verifyUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser == null) {
            goLogInScreen();
        }
    }

    private void goLogInScreen() {
        Intent intent = new Intent(this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.profileItem) {
            goProfileScreen();
        }

        return super.onOptionsItemSelected(item);
    }

    private void goProfileScreen() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
