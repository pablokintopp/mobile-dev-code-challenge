package com.arctouch.pablo.tmdb.view.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arctouch.pablo.tmdb.R;
import com.arctouch.pablo.tmdb.databinding.MovieDetailActivityBinding;
import com.arctouch.pablo.tmdb.service.model.Movie;
import com.arctouch.pablo.tmdb.viewmodel.MovieDetailViewModel;

import org.parceler.Parcels;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String KEY_MOVIE = "key_movie";


    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_MOVIE, Parcels.wrap(movie));
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Movie movie = Parcels.unwrap(getIntent().getExtras().getParcelable(KEY_MOVIE));
        MovieDetailViewModel movieDetailViewModel = new MovieDetailViewModel(movie, this);
        MovieDetailActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.movie_detail_activity);
        binding.setMdvm(movieDetailViewModel);

    }
}
