package com.pollarusia2018.pollaupb;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.pollarusia2018.pollaupb.adapters.CountriesAdapter;
import com.pollarusia2018.pollaupb.adapters.PartidosAdapter;
import com.pollarusia2018.pollaupb.models.Country;
import com.pollarusia2018.pollaupb.models.Partido;

public class PartidosActivity extends AppCompatActivity {

    private RecyclerView partidosRecyclerView;
    private PartidosAdapter partidosAdapter;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos);

        partidosRecyclerView = findViewById(R.id.partidosRecyclerView);
        partidosRecyclerView.setHasFixedSize(true);
        partidosRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        partidosAdapter = new PartidosAdapter(this);
        partidosRecyclerView.setAdapter(partidosAdapter);

        db = FirebaseFirestore.getInstance();

        loadData();
    }


    private void loadData() {

        db.collection("partidos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            partidosAdapter.clear();

                            for (DocumentSnapshot document : task.getResult()) {

                                String name1 = document.getString("name1");
                                String flagURL1 = document.getString("flagURL1");

                                String name2 = document.getString("name2");
                                String flagURL2 = document.getString("flagURL2");

                                 String score1 = document.getString("score1");
                                 String score2 = document.getString("score2");

                                 String horario = document.getString("horario");
                                 String estadio = document.getString("estadio");


                                Partido p = new Partido(new Country(name1, flagURL1), new Country(name2, flagURL2), score1, score2, horario, estadio);

                                partidosAdapter.addPartido(p);

                            }

                        } else {

                        }
                    }
                });

    }
}
