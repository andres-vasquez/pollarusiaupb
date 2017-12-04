package com.pollarusia2018.pollaupb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private TextView emailTextView;
    private TextView nameTextView;
    private TextView numberTextView;
    private CircleImageView profileImageView;

    private GoogleApiClient googleApiClient;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailTextView = findViewById(R.id.emailTextView);
        profileImageView = findViewById(R.id.profileImageView);
        numberTextView =  findViewById(R.id.numberTextView);
        nameTextView = findViewById(R.id.nameTextView);

        firebaseAuth = FirebaseAuth.getInstance();

        setupUser();
    }

    private void setupUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {

            String email = firebaseUser.getEmail();
            String photoURL = firebaseUser.getPhotoUrl().toString();
            String name = firebaseUser.getDisplayName();
            String phone = firebaseUser.getPhoneNumber();

            if(email!=null) {
                emailTextView.setText(email);
            }
            if(name!=null) {
                nameTextView.setText(name);
            }
            if(phone!=null) {
                numberTextView.setText(phone);
            }
            if(photoURL!=null) {
                Glide.with(this).load(photoURL).into(profileImageView);
            }
        }
    }

    public void logOut(View view) {
        firebaseAuth.signOut();
        goLogInScreen();
    }

    private void goLogInScreen() {
        Intent intent = new Intent(this,LogInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
