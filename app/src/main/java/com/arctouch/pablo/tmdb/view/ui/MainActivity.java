package com.arctouch.pablo.tmdb.view.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arctouch.pablo.tmdb.R;
import com.arctouch.pablo.tmdb.databinding.MainActivityBinding;
import com.arctouch.pablo.tmdb.service.model.Movie;
import com.arctouch.pablo.tmdb.view.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.movieList.setLayoutManager(layoutManager);

        List<Movie> upcomingMovies = new ArrayList<>();

        // ToDo Load Data

        MovieAdapter adapter = new MovieAdapter(upcomingMovies, this);
        binding.movieList.setAdapter(adapter);





    }
}
