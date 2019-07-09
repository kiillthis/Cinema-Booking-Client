package com.cinema.client.ui.InfoAboutCinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cinema.client.R;
import com.cinema.client.data.User;
import com.cinema.client.ui.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

public class UserInfoActivity extends AppCompatActivity {
    public static final String ARG_KEY_USER_BUNDLE = "user_key_bundle";
    public static final String ARG_KEY_USER = "user_key";
    private ImageView userPhoto;
    private TextView username;
    private TextView phone;
    private TextView email;
    private TextView card;
    private TextView ticket;
    private TextView favorite;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);

        username = (TextView)findViewById(R.id.user_name);
        phone = (TextView)findViewById(R.id.user_telephone);
        email = (TextView)findViewById(R.id.user_email);
        card = (TextView)findViewById(R.id.card_text);
        ticket = (TextView)findViewById(R.id.ticket);
        favorite = (TextView)findViewById(R.id.favorit_movie);
        exit = (Button)findViewById(R.id.logout);
        userPhoto = (ImageView)findViewById(R.id.user_poster);

        final User user = (User)getIntent().getBundleExtra(ARG_KEY_USER_BUNDLE).getSerializable(ARG_KEY_USER);

        if(user == null){
            Toast.makeText(this,"Can`t get user",Toast.LENGTH_SHORT).show();
            finish();
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username.setText(user.getNickname());
        phone.setText(user.getPhone());
        email.setText(user.getEmail());
        card.setText(user.getCard());
        //ticket.setText(user.getTicket().getSession().getMovieId());
        //favorite.setText(user.getFavorite());
        card.setText("Оно тут будет");
        ticket.setText("Нужно");
        favorite.setText("Скоро будет");
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserInfoActivity.this, HomeActivity.class));
            }
        });

    }
}
