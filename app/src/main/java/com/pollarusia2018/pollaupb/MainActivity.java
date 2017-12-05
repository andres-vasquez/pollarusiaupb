package com.pollarusia2018.pollaupb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.pollarusia2018.pollaupb.adapters.CountriesAdapter;
import com.pollarusia2018.pollaupb.models.Country;

public class MainActivity extends AppCompatActivity {

    private RecyclerView countriesRecyclerView;
    private CountriesAdapter countriesAdapter;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countriesRecyclerView = (RecyclerView) findViewById(R.id.countriesRecyclerView);
        countriesRecyclerView.setHasFixedSize(true);
        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        countriesAdapter = new CountriesAdapter(this);
        countriesRecyclerView.setAdapter(countriesAdapter);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        verifyUser();

//        loadData();

        loadDataRealtime();
    }

    private void loadDataRealtime() {
        db.collection("countries")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                        countriesAdapter.clear();
                        for (DocumentSnapshot document : documentSnapshots) {
                            Country c = document.toObject(Country.class);
                            countriesAdapter.addCountry(c);
                        }
                    }
                });
    }

    private void loadData() {

        db.collection("countries")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            countriesAdapter.clear();

                            for (DocumentSnapshot document : task.getResult()) {

                                String name = document.getString("name");
                                String flagURL = document.getString("flagURL");

                                Country c = new Country(name, flagURL);

                                countriesAdapter.addCountry(c);

                            }

                        } else {

                        }
                    }
                });

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
