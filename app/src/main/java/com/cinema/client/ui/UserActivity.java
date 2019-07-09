package com.cinema.client.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.cinema.client.R;
import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity {
    private ImageView imgPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_page);


    }
}
