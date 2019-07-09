package com.cinema.client.ui.fragments.soon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cinema.client.R;
import com.cinema.client.data.movie.Movie;
import com.cinema.client.data.movie.MoviesRepository;
import com.cinema.client.ui.MovieDetailActivity;
import com.cinema.client.ui.MovieDetailSoonActivity;
import com.cinema.client.ui.adapters.MoviesAdapter;
import com.cinema.client.ui.fragments.now.NowFragment;

import java.util.Arrays;

public class SoonFragment extends Fragment {

    private MoviesAdapter adapter = new MoviesAdapter();
    private RecyclerView moviesReyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soon, container, false);

        moviesReyclerView = view.findViewById(R.id.soon_in_cinema_recycler_view);

        moviesReyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.setOnMovieClickedListener(new MoviesAdapter.OnMovieClickedListener() {
            @Override
            public void onMovieClicked(Movie movie) {
                Intent intent = new Intent(getActivity(), MovieDetailSoonActivity.class);
                Bundle args = new Bundle();
                args.putSerializable(MovieDetailActivity.ARG_KEY_MOVIE,movie);
                intent.putExtra(MovieDetailActivity.ARG_KEY_MOVIE_BUNDLE,args);
                startActivity(intent);
            }
        });

        moviesReyclerView.setAdapter(adapter);

        return view;
    }


    MyReceiver receiver;

    @Override
    public void onStart() {
        super.onStart();

        receiver = new MyReceiver();
        getActivity().registerReceiver(receiver, new IntentFilter("SOON_MOVIES"));

        MoviesRepository.generateSoon();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (receiver != null) {
            getActivity().unregisterReceiver(receiver);
        }
    }


    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle b = intent.getBundleExtra("bundle2");

            Movie movies = (Movie) b.getSerializable("soon");

            // google pass array of object to broadcast receiver

            adapter.addItems(Arrays.asList(movies));
        }
    }
}



