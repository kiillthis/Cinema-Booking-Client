package com.cinema.client.data.movie;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cinema.client.data.DataBase;
import com.cinema.client.ui.adapters.MoviesAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class MoviesRepository {

    public static void generateNewMovies(){

        new DataBase().getMovies();
       // movies.add(new DataBase().getMovies().get(1));


//        movies.add(new Movie(
//                //title
//                "Аладин!",
//                //shortDescription
//                "Каждый из нас в душе супергерой, однако надо немного магии, чтобы раскрыть его. Воспитанному улицей 14-летнему Билли Батсону повезло: он способен превращаться во взрослого супергероя Шазама.",
//                //full Description
//                "Каждый из нас в душе супергерой, однако надо немного магии, чтобы раскрыть его. Воспитанному улицей 14-летнему Билли Батсону повезло: он способен превращаться во взрослого супергероя Шазама.",
//                //poster image url
//                "https://multiplex.ua/images/e8/af/e8afb14d21a62766ef5f114450850afc.jpeg"
//        ));


    }
    public static void generateSoon(){
        new DataBase().createSoon();

    }
}
