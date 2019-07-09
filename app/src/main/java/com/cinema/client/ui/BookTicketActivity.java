package com.cinema.client.ui;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cinema.client.R;
import com.cinema.client.data.DataBase;
import com.cinema.client.data.session.Session;

import java.util.ArrayList;
import java.util.List;

public class BookTicketActivity extends AppCompatActivity {

    private List<Integer> bookedPlaces = new ArrayList<>();
    private ArrayList<Integer> yourPlaces = new ArrayList<>();
    private Button btnBookPlaces;
    public static final String ARG_KEY_SESSION_BUNDLE = "session_key_bundle";
    public static final String ARG_KEY_SESSION = "session_key";
    private TextView tvY;
    private TextView tvC;
    private TextView tvN;
    private TextView row1;
    private TextView row2;
    private TextView row3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);

        btnBookPlaces = (Button)findViewById(R.id.btn_boock);
        btnBookPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookTickets();
            }
        });

        Session session = (Session) getIntent().getBundleExtra(ARG_KEY_SESSION_BUNDLE).getSerializable(ARG_KEY_SESSION);
        bookedPlaces = session.getSeats();
        tvY = (TextView)findViewById(R.id.tv_1);
        tvC = (TextView)findViewById(R.id.tv_2);
        tvN = (TextView)findViewById(R.id.tv_3);

        tvY.setText("Свободно");
        tvC.setText("Выбрано");
        tvN.setText("Занято");

        row1 = (TextView)findViewById(R.id.tv_row_1);
        row2 = (TextView)findViewById(R.id.tv_row_2);
        row3 = (TextView)findViewById(R.id.tv_row_3);
        row1.setText("Ряд 1");
        row2.setText("Ряд 2");
        row3.setText("Ряд 3");

        final Button place_1_1 = (Button) findViewById(R.id.place_1_1);
        final Button place_1_2 = (Button) findViewById(R.id.place_1_2);
        final Button place_1_3 = (Button) findViewById(R.id.place_1_3);
        final Button place_1_4 = (Button) findViewById(R.id.place_1_4);
        final Button place_1_5 = (Button) findViewById(R.id.place_1_5);

        final Button place_2_1 = (Button) findViewById(R.id.place_2_1);
        final Button place_2_2 = (Button) findViewById(R.id.place_2_2);
        final Button place_2_3 = (Button) findViewById(R.id.place_2_3);
        final Button place_2_4 = (Button) findViewById(R.id.place_2_4);
        final Button place_2_5 = (Button) findViewById(R.id.place_2_5);

        final Button place_3_1 = (Button) findViewById(R.id.place_3_1);
        final Button place_3_2 = (Button) findViewById(R.id.place_3_2);
        final Button place_3_3 = (Button) findViewById(R.id.place_3_3);
        final Button place_3_4 = (Button) findViewById(R.id.place_3_4);
        final Button place_3_5 = (Button) findViewById(R.id.place_3_5);


        if(checkPlace(1)){
            place_1_1.setBackgroundColor(Color.RED);
        } else {
            place_1_1.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(2)){
            place_1_2.setBackgroundColor(Color.RED);
        } else {
            place_1_2.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(3)){
            place_1_3.setBackgroundColor(Color.RED);
        } else {
            place_1_3.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(4)){
            place_1_4.setBackgroundColor(Color.RED);
        } else {
            place_1_4.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(5)){
            place_1_5.setBackgroundColor(Color.RED);
        } else {
            place_1_5.setBackgroundColor(Color.GREEN);
        }

        if(checkPlace(6)){
            place_2_1.setBackgroundColor(Color.RED);
        } else {
            place_2_1.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(7)){
            place_2_2.setBackgroundColor(Color.RED);
        } else {
            place_2_2.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(8)){
            place_2_3.setBackgroundColor(Color.RED);
        } else {
            place_2_3.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(9)){
            place_2_4.setBackgroundColor(Color.RED);
        } else {
            place_2_4.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(10)){
            place_2_5.setBackgroundColor(Color.RED);
        } else {
            place_2_5.setBackgroundColor(Color.GREEN);
        }

        if(checkPlace(11)){
            place_3_1.setBackgroundColor(Color.RED);
        } else {
            place_3_1.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(12)){
            place_3_2.setBackgroundColor(Color.RED);
        } else {
            place_3_2.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(13)){
            place_3_3.setBackgroundColor(Color.RED);
        } else {
            place_3_3.setBackgroundColor(Color.GREEN);
        }

        if(checkPlace(14)){
            place_3_4.setBackgroundColor(Color.RED);
        } else {
            place_3_4.setBackgroundColor(Color.GREEN);
        }
        if(checkPlace(15)){
            place_3_5.setBackgroundColor(Color.RED);
        } else {
            place_3_5.setBackgroundColor(Color.GREEN);
        }



        place_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(1)) {
                    place_1_1.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(1);
                    yourPlaces.add(1);
                }else if (checkYourPlace(1)){
                    place_1_1.setBackgroundColor(Color.GREEN);
                    deletePlaces(1);
                }
            }
        });
        place_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(2)) {
                    place_1_2.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(2);
                    yourPlaces.add(2);
                }else if (checkYourPlace(2)){
                    place_1_2.setBackgroundColor(Color.GREEN);
                    deletePlaces(2);
                }
            }
        });
        place_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkPlace(3)) {
                    place_1_3.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(3);
                    yourPlaces.add(3);
                } else if (checkYourPlace(3)) {
                    place_1_3.setBackgroundColor(Color.GREEN);
                    deletePlaces(3);
                }
            }
        });
        place_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(4)){
                    place_1_4.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(4);
                    yourPlaces.add(4);
                }else if (checkYourPlace(4)){
                    place_1_4.setBackgroundColor(Color.GREEN);
                    deletePlaces(4);
                }
            }
        });
        place_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(5)) {
                    place_1_5.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(5);
                    yourPlaces.add(5);
                }else if (checkYourPlace(5)){
                    place_1_5.setBackgroundColor(Color.GREEN);
                    deletePlaces(5);
                }
            }
        });
        place_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(6)) {
                    place_2_1.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(6);
                    yourPlaces.add(6);
                }else if (checkYourPlace(6)){
                    place_2_1.setBackgroundColor(Color.GREEN);
                    deletePlaces(6);
                }
            }
        });
        place_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(7)) {
                    place_2_2.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(7);
                    yourPlaces.add(7);
                }else if (checkYourPlace(7)){
                    place_2_2.setBackgroundColor(Color.GREEN);
                    deletePlaces(7);
                }
            }
        });
        place_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(8)) {
                    place_2_3.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(8

                    );
                    yourPlaces.add(8);
                }else if (checkYourPlace(8)){
                    place_2_3.setBackgroundColor(Color.GREEN);
                    deletePlaces(8);
                }
            }
        });
        place_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(9)) {
                    place_2_4.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(9);
                    yourPlaces.add(9);
                }else if (checkYourPlace(9)){
                    place_2_4.setBackgroundColor(Color.GREEN);
                    deletePlaces(9);
                }
            }
        });
        place_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(10)) {
                    place_2_5.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(10);
                    yourPlaces.add(10);
                }else if (checkYourPlace(10)){
                    place_2_5.setBackgroundColor(Color.GREEN);
                    deletePlaces(10);
                }
            }
        });
        place_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(11)) {
                    place_3_1.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(11);
                    yourPlaces.add(11);
                }else if (checkYourPlace(11)){
                    place_3_1.setBackgroundColor(Color.GREEN);
                    deletePlaces(11);
                }
            }
        });
        place_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(12)) {
                    place_3_2.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(12);
                    yourPlaces.add(12);
                }else if (checkYourPlace(12)){
                    place_3_2.setBackgroundColor(Color.GREEN);
                    deletePlaces(12);
                }
            }
        });
        place_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(13)) {
                    place_3_3.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(13);
                    yourPlaces.add(13);
                }else if (checkYourPlace(13)){
                    place_3_3.setBackgroundColor(Color.GREEN);
                    deletePlaces(13);
                }
            }
        });
        place_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(14)) {
                    place_3_4.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(14);
                    yourPlaces.add(14);
                }else if (checkYourPlace(14)){
                    place_3_4.setBackgroundColor(Color.GREEN);
                    deletePlaces(14);
                }
            }
        });
        place_3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkPlace(15)) {
                    place_3_5.setBackgroundColor(Color.YELLOW);
                    bookedPlaces.add(15);
                    yourPlaces.add(15);
                }else if (checkYourPlace(15)){
                    place_3_5.setBackgroundColor(Color.GREEN);
                    deletePlaces(15);
                }
            }
        });

    }

    private void updatePlaces(){

    }

    private void bookTickets(){
        new DataBase().updateSession(bookedPlaces);
        recreate();
        Toast.makeText(getApplicationContext(),"Успешно забранировано", Toast.LENGTH_SHORT).show();
    }

    private boolean checkYourPlace(int number){
        if(yourPlaces.contains(number)){
            return true;
        }
        return false;

    }
    private void deletePlaces(int number){
        if(bookedPlaces.contains(number) && yourPlaces.contains(number)){
            yourPlaces.remove(yourPlaces.indexOf(number));
            bookedPlaces.remove(bookedPlaces.indexOf(number));
        }
        return;
    }
    private boolean checkPlace(int number){
        if (bookedPlaces.contains(number)){
            return true;
        }
        return false;
    }
}