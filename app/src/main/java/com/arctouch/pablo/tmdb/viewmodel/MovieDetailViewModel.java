package com.arctouch.pablo.tmdb.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.arctouch.pablo.tmdb.service.model.Movie;
import com.bumptech.glide.Glide;

/**
 * Created by Pablo
 */

public class MovieDetailViewModel extends BaseObservable{

    private Movie mMovie;
    private Context mContext;

    public MovieDetailViewModel(Movie mMovie, Context mContext) {
        this.mMovie = mMovie;
        this.mContext = mContext;
    }

    public  String getTitle(){
        return mMovie.getTitle();
    }

    public  String getReleaseDate(){
        return mMovie.getReleaseDate();
    }


    public String getBackdropPath(){
        return mMovie.getBackdropPath();
    }

    public String getPosterPath(){
        return mMovie.getPosterPath();
    }

    public String getOverview(){
        return mMovie.getOverview();
    }

    public String getGenres(){
        return mMovie.getGenresNames();

    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }


}
