package com.arctouch.pablo.tmdb.service.repository;

import com.arctouch.pablo.tmdb.service.model.GenreList;
import com.arctouch.pablo.tmdb.service.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Pablo
 */

public interface TmdbService {

    String API_URL = "https://api.themoviedb.org/3/";

    String API_KEY = "1f54bd990f1cdfb230adb312546d765d";


    @GET("movie/upcoming")
    Call<MovieList> getUpcomingMovies(@Query("api_key") String apiKey, @Query("page") int pageNumber);

    @GET("genre/movie/list")
    Call<GenreList> getGenresList(@Query("api_key") String apiKey);







}
