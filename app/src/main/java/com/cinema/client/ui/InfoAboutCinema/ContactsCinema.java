package com.cinema.client.ui.InfoAboutCinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.cinema.client.R;
import com.cinema.client.data.movie.Movie;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;


public class ContactsCinema extends AppCompatActivity  {
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvAddress;
    private TextView tvTime;
    private ImageView imgPhone;
    private ImageView imgEmail;
    private ImageView imgTime;
    private ImageView imgMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_cinema);

        tvPhone = (TextView)findViewById(R.id.tv_phone);
        tvEmail = (TextView)findViewById(R.id.tv_email);
        tvAddress= (TextView)findViewById(R.id.tv_address);
        tvTime = (TextView)findViewById(R.id.tv_time);
        imgEmail = (ImageView)findViewById(R.id.img_email);
        imgPhone = (ImageView)findViewById(R.id.img_phone);
        imgTime = (ImageView)findViewById(R.id.img_time);
        imgMap = (ImageView)findViewById(R.id.map);


        tvPhone.setText("Телефон:0800 505 333\n" +
                "        0962 818 841\n" +
                "        0663 474 652");
        tvEmail.setText("Email: onpu.cinema@gmail.com");
        tvTime.setText("Время работы: с 10:00 \n" +
                        "до 00:00");
        tvAddress.setText("Адрес: Генуезька вулиця, \n" +
                "5/2, ТРЦ Gagarinn Plaza, Одеса, \n" +
                "Odessa oblast, 65000");

    }

}
