package com.cinema.client.ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.cinema.client.R;
import com.cinema.client.data.User;
import com.cinema.client.data.session.Session;

public class HallActivity extends AppCompatActivity {
    public int dist;
    public int distance1;
    TextView amcdist;
    TextView regaldist;
    TextView landmark;
    public static final String ARG_KEY_SESSION_BUNDLE = "session_key_bundle";
    public static final String ARG_KEY_SESSION = "session_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);

        Bundle b = getIntent().getExtras();
        //final int movie = b.getInt("movie_id");
        //final String date = b.getString("date");

        Session session = (Session) getIntent().getBundleExtra(ARG_KEY_SESSION_BUNDLE).getSerializable(ARG_KEY_SESSION);



//
//        Button a1 = (Button) findViewById(R.id.button9);
//        Button AMC2 = (Button) findViewById(R.id.AMC2);
//        Button AMC3 = (Button) findViewById(R.id.AMC3);
//        Button AMC4 = (Button) findViewById(R.id.AMC4);
//        Button AMC5 = (Button) findViewById(R.id.AMC5);
//
//        Button RC1 = (Button) findViewById(R.id.RC1);
//        Button RC2 = (Button) findViewById(R.id.RC2);
//        Button RC3 = (Button) findViewById(R.id.RC3);
//        Button RC4 = (Button) findViewById(R.id.RC4);
//
//        Button LMC1 = (Button) findViewById(R.id.LMC1);
//        Button LMC2 = (Button) findViewById(R.id.LMC2);
//        Button LMC3 = (Button) findViewById(R.id.LMC3);
//        Button LMC4 = (Button) findViewById(R.id.LMC4);
//        Button LMC5 = (Button) findViewById(R.id.LMC5);
//
//         amcdist = (TextView) findViewById(R.id.amcdist);
//         regaldist = (TextView) findViewById(R.id.regaldist);
//         landmark  = (TextView) findViewById(R.id.landmarkdist);
//
//        distance1 = distance(41.891000, -87.620100);
//        if(distance1 == 0) {
//            Toast.makeText(getApplicationContext(), "Please Switch on GPS to find the Theatre Distance", Toast.LENGTH_SHORT).show();
//            amcdist.setText(Integer.toString(distance1) + " mi");
//            distance1 = distance(41.751352, -87.583533);
//            regaldist.setText(Integer.toString(distance1) + " mi");
//            distance1 = distance(41.933400, -87.645600);
//            landmark.setText(Integer.toString(distance1) + " mi");
//            final SwipeRefreshLayout swipe = (SwipeRefreshLayout) findViewById(R.id.activity_theatre);
//            swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                @Override
//                public void onRefresh() {
//                    swipe.setRefreshing(true);
//                    ( new Handler()).postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            swipe.setRefreshing(false);
//                            distance1 = distance(41.891000, -87.620100);
//                            amcdist.setText(Integer.toString(distance1) + " mi");
//                            distance1 = distance(41.751352, -87.583533);
//                            regaldist.setText(Integer.toString(distance1) + " mi");
//                            distance1 = distance(41.933400, -87.645600);
//                            landmark.setText(Integer.toString(distance1) + " mi");
//                        }
//                    },2000);
//                }
//            });
//        }
//        else{
//            amcdist.setText(Integer.toString(distance1) + " mi");
//            distance1 = distance(41.751352, -87.583533);
//            regaldist.setText(Integer.toString(distance1) + " mi");
//            distance1 = distance(41.933400, -87.645600);
//            landmark.setText(Integer.toString(distance1) + " mi");
//        }
//
//        a1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "AMC");
//                intent.putExtra("time", "11:55 AM");
//                startActivity(intent);
//
//            }
//        });
//
//        AMC2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "AMC");
//                intent.putExtra("time", "02.15 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        AMC3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "AMC");
//                intent.putExtra("time", "05.30 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        AMC4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "AMC");
//                intent.putExtra("time", "07.15 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        AMC5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "AMC");
//                intent.putExtra("time", "09.15 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        RC1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Regal Cinemas");
//                intent.putExtra("time", "12.05 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        RC2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Regal Cinemas");
//                intent.putExtra("time", "04.15 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        RC3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Regal Cinemas");
//                intent.putExtra("time", "07.05 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        RC4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Regal Cinemas");
//                intent.putExtra("time", "19.15 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        LMC1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Land Mark");
//                intent.putExtra("time", "11.30 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        LMC2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Land Mark");
//                intent.putExtra("time", "02.45 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        LMC3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Land Mark");
//                intent.putExtra("time", "04.30 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        LMC4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Land Mark");
//                intent.putExtra("time", "07.05 PM");
//                startActivity(intent);
//
//            }
//        });
//
//        LMC5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Theatre.this, SeatSelection.class);
//                intent.putExtra("movie_id", movie);
//                intent.putExtra("date", date);
//                intent.putExtra("theatre", "Land Mark");
//                intent.putExtra("time", "09.15 PM");
//                startActivity(intent);
//
//            }
//        });

    }

        /*Intent intent = new Intent(Theatre.this, SeatSelection.class);
        intent.putExtra("movie_id", movie);
        intent.putExtra("date", date);*/
}
