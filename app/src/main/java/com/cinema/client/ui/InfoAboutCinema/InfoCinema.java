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

public class InfoCinema extends AppCompatActivity {

    private ImageView imgCinemaPoster;
    private TextView tvAboutCinema;
    private TextView tv_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        imgCinemaPoster = (ImageView) findViewById(R.id.cinema_poster);
        tvAboutCinema = (TextView) findViewById(R.id.about_us);
        tv_name = (TextView) findViewById(R.id.tv_name);

        tv_name.setText("О компании");
        tvAboutCinema.setText("Кинотеатры ONPU Cinema преданы инновациям, которые вы видите в фильмах. Это не просто поход в кино, в ONPU Cinema вы действительно почувствуете разницу - мы обеспечиваем превосходную акустику, более богатые изображения и новейшие технологии по всей Украине.\n" +
                "Наслаждайтесь разнообразием нашего бара, почувствуйте новые, смелые вкусы, расслабьтесь в просторном комфорте наших залов и приходите получать лучшие впечатления от современных развлечений! \n" +
                "\n" +
                "В ONPU Cinema вы сможете не просто посмотреть фильмы, но и пережить их.\n" +
                "\n" +
                "24 кинотеатра\n" +
                "131 зал в крупнейших городах Украины\n" +
                "25'000 гостей ежедневно\n" +
                "750 сеансов ежедневно");
    }
}
