package com.pollarusia2018.pollaupb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private TextView emailTextView;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailTextView = findViewById(R.id.emailTextView);

        firebaseAuth = FirebaseAuth.getInstance();

        setupUser();
    }

    private void setupUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {

            String email = firebaseUser.getEmail();

            emailTextView.setText(email);
        }
    }

    public void logOut(View view) {
        firebaseAuth.signOut();
    }
}
