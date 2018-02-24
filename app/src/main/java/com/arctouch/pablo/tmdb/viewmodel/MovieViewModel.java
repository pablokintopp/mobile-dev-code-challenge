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
import com.bumptech.glide.Glide;

/**
 * Created by Pablo
 */

public class MovieViewModel  extends BaseObservable{

    private Movie mMoview;
    private Context mContext;

    public MovieViewModel(Movie mMovie, Context mContext) {
        this.mMoview = mMovie;
        this.mContext = mContext;
    }

    public  String getTitle(){
        return mMoview.getTitle();
    }

    public  String getReleaseDate(){
        return mMoview.getReleaseDate();
    }


    public String getBackdropPath(){
        return mMoview.getBackdropPath();
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public View.OnClickListener onReadMoreClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Opens movie detail", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
