package com.arctouch.pablo.tmdb.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.arctouch.pablo.tmdb.R;
import com.arctouch.pablo.tmdb.databinding.MovieItemBinding;
import com.arctouch.pablo.tmdb.service.model.Movie;
import com.arctouch.pablo.tmdb.viewmodel.MovieViewModel;

import java.util.List;

/**
 * Created by Pablo
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.BindingHolder>{

    private List<Movie> mMovies;
    private Context mContext;

    public MovieAdapter(List<Movie> mMovies, Context mContext) {
        this.mMovies = mMovies;
        this.mContext = mContext;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movie_item, parent, false);

        return  new BindingHolder(binding);

    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        MovieItemBinding binding = holder.binding;
        binding.setMvm(new MovieViewModel(mMovies.get(position),mContext));

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void addItems(List<Movie> newMoviews){
        this.mMovies.addAll(newMoviews);
        this.notifyDataSetChanged();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private MovieItemBinding binding;

        public BindingHolder(MovieItemBinding binding) {
            super(binding.contactCard);
            this.binding = binding;
        }
    }
}
