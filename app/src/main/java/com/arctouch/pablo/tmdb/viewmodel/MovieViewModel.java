package com.arctouch.pablo.tmdb.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.arctouch.pablo.tmdb.BR;
import com.arctouch.pablo.tmdb.service.model.Movie;
import com.arctouch.pablo.tmdb.view.ui.MovieDetailActivity;
import com.bumptech.glide.Glide;

/**
 * Created by Pablo
 */

public class MovieViewModel  extends BaseObservable{

    private Movie mMovie;
    private Context mContext;

    public MovieViewModel(Movie mMovie, Context mContext) {
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

    public String getGenres(){
        return mMovie.getGenresNames();

    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public View.OnClickListener onReadMoreClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               view.getContext().startActivity(MovieDetailActivity.newIntent(view.getContext(), mMovie));
            }
        };
    }

}
