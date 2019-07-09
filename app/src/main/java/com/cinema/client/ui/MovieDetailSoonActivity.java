package com.cinema.client.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cinema.client.R;
import com.cinema.client.data.movie.Movie;
import com.cinema.client.ui.InfoAboutCinema.UserInfoActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;
import com.squareup.picasso.Picasso;

public class MovieDetailSoonActivity extends AppCompatActivity {
    public static final String ARG_KEY_MOVIE_BUNDLE = "movie_key_bundle";
    public static final String ARG_KEY_MOVIE = "movie_key";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ImageView imgMoviePoster;
    private TextView tvMovieName;
    private TextView tvMovieAbout;
    private TextView tvMovieInfo;
    private TextView tvMovieLabel;

    private YouTubePlayerView videoViewTrailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_page_soon);

        mAuth = FirebaseAuth.getInstance();

        imgMoviePoster = (ImageView)findViewById(R.id.movie_poster);
        tvMovieName = (TextView)findViewById(R.id.movie_name);
        tvMovieAbout = (TextView)findViewById(R.id.about_movie);
        tvMovieInfo = (TextView)findViewById(R.id.movie_info);
        tvMovieLabel = (TextView)findViewById(R.id.movie_trailer_label);

        videoViewTrailer = (YouTubePlayerView)findViewById(R.id.movie_trailer_video);

        final Movie movie = (Movie)getIntent().getBundleExtra(ARG_KEY_MOVIE_BUNDLE).getSerializable(ARG_KEY_MOVIE);

        if(movie == null){
            Toast.makeText(this,"Can`t get movie",Toast.LENGTH_SHORT).show();
            finish();
        }

        setTitle(movie.getTitle());

        videoViewTrailer.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(final YouTubePlayer initializedYouTubePlayer) {
                initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        initializedYouTubePlayer.loadVideo(movie.getVideoUrl(), 0);
                    }
                });
            }
        }, true);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.get().load(movie.getVerticalPosterUrl()).into(imgMoviePoster);
        tvMovieName.setText(movie.getTitle());
        tvMovieAbout.setText(movie.getShortDescription());
        tvMovieInfo.setText(movie.getFullDescription());


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return false;
    }
}