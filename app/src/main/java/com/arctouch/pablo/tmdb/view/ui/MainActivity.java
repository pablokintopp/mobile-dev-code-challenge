package com.arctouch.pablo.tmdb.view.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.arctouch.pablo.tmdb.R;
import com.arctouch.pablo.tmdb.databinding.MainActivityBinding;
import com.arctouch.pablo.tmdb.service.model.Genre;
import com.arctouch.pablo.tmdb.service.model.GenreList;
import com.arctouch.pablo.tmdb.service.model.Movie;
import com.arctouch.pablo.tmdb.service.model.MovieList;
import com.arctouch.pablo.tmdb.service.repository.TmdbService;
import com.arctouch.pablo.tmdb.view.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static Retrofit retrofit = null;
    private MovieAdapter moviesAdapter = null;
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityBinding binding = null;
    private int pagination = 1;
    private List<Genre> genres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.movieList.setLayoutManager(layoutManager);

        LoadApiData();


    }

    private void LoadApiData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(TmdbService.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        TmdbService tmdbService =  retrofit.create(TmdbService.class);


        Call<GenreList> callGenres = tmdbService.getGenresList(tmdbService.API_KEY);


        callGenres.enqueue(new Callback<GenreList>() {
            @Override
            public void onResponse(Call<GenreList> callGenres, Response<GenreList> response) {
                genres = response.body().getGenres();
                Log.d(TAG, "genres received: " + genres.size() );

                LoadMoviesData();




            }

            @Override
            public void onFailure(Call<GenreList> callGenres, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

    }

    private void LoadMoviesData() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(TmdbService.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        TmdbService tmdbService =  retrofit.create(TmdbService.class);


            Call<MovieList> call = tmdbService.getUpcomingMovies(tmdbService.API_KEY, pagination);


            call.enqueue(new Callback<MovieList>() {
                @Override
                public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                    List<Movie> movies = response.body().getResults();
                    for ( Movie movie: movies) {
                        movie.updateGenre(genres);
                    }
                    int totalPages =  response.body().getTotalPages();

                    if(moviesAdapter == null) {
                        moviesAdapter = new MovieAdapter(movies, getApplicationContext());
                        binding.movieList.setAdapter(moviesAdapter);
                    }else{
                        moviesAdapter.addItems(movies);
                    }

                    Log.d(TAG, "Movies received: " + movies.size()+" page: "+ pagination );
                    pagination++;
                    if(pagination <= totalPages)
                        LoadMoviesData();
                }

                @Override
                public void onFailure(Call<MovieList> call, Throwable throwable) {
                    Log.e(TAG, throwable.toString());

                }
            });


    }
}
