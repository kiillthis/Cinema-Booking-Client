package com.cinema.client.ui;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cinema.client.R;
import com.cinema.client.data.DataBase;
import com.cinema.client.data.User;
import com.cinema.client.data.movie.Movie;
import com.cinema.client.data.session.Session;
import com.cinema.client.ui.InfoAboutCinema.UserInfoActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DateActivity extends  AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView Output;
    private Button changeDate;
    private int year;
    private int month;
    private int day;
    public String date;
    DatePickerDialog dpd;
    static final int DATE_PICKER_ID = 1111;
    int mid;
    Session session;
    List<Session> listSession = new ArrayList<>();
    public static final String ARG_KEY_DATE_BUNDLE = "date_key_bundle";
    public static final String ARG_KEY_DATE = "date_key";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mAuth = FirebaseAuth.getInstance();

        Output = (TextView) findViewById(R.id.tvDate);
        changeDate = (Button) findViewById(R.id.btnChangeDate);
        TextView tv = (TextView) findViewById(R.id.textView8);

        Bundle b = getIntent().getExtras();

        Movie movie = (Movie) getIntent().getBundleExtra(ARG_KEY_DATE_BUNDLE).getSerializable(ARG_KEY_DATE);
        mid = movie.getId();

        MyReceiver receiver = new MyReceiver();
        DateActivity.this.registerReceiver(receiver, new IntentFilter("SESSION"));
        new DataBase().getSession(mid);

        //final int movie = b.getInt("booktype");




        // Get current date by calender

        final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);

        // Show current date

        /*Output.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));*/

        // Button listener to show date picker dialog

        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // On button click show datepicker dialog
                showDialog(DATE_PICKER_ID);

            }

        });

        Button btw = (Button) findViewById(R.id.next);

        btw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(date!=null) {

                    for(Session s : listSession) {
                        if (s.getDate().equals(date)) {
                            Intent intent = new Intent(DateActivity.this, BookTicketActivity.class);
                            Bundle args = new Bundle();
                            args.putSerializable(HallActivity.ARG_KEY_SESSION, session);
                            intent.putExtra(HallActivity.ARG_KEY_SESSION_BUNDLE, args);
                            //intent.putExtra("movie_id", movie);
                            //intent.putExtra("date", date);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(),"Сеансы на это число на этот фильм не найдены", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please Select the DateActivity", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                Calendar max = Calendar.getInstance();
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                dpd=new DatePickerDialog(this, pickerListener, year, month,day);
                c.add(Calendar.DAY_OF_MONTH, 1);
                dpd.getDatePicker().setMinDate(c.getTimeInMillis());
                max.add(Calendar.DAY_OF_MONTH, 50);
                dpd.getDatePicker().setMaxDate(max.getTimeInMillis());

                return dpd;

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;
            date = Integer.toString(month + 1) + "/" + Integer.toString(day) + "/"  + Integer.toString(year);

            // Show selected date
            Output.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

        }
    };
    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle b = intent.getBundleExtra("sessionBundle");
            session = (Session) b.getSerializable("session");
            listSession.add(session);

        }
    }
}
