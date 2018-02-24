package com.arctouch.pablo.tmdb.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.arctouch.pablo.tmdb.R;
import com.arctouch.pablo.tmdb.databinding.MovieItemBinding;
import com.arctouch.pablo.tmdb.service.model.Movie;
import com.arctouch.pablo.tmdb.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.BindingHolder> implements Filterable{

    private List<Movie> mMovies;
    private Context mContext;

    private List<Movie> movieListFiltered;


    public MovieAdapter(List<Movie> mMovies, Context mContext) {
        this.mMovies = mMovies;
        this.mContext = mContext;
        this.movieListFiltered = mMovies;
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
        binding.setMvm(new MovieViewModel(movieListFiltered.get(position), mContext));

    }

    @Override
    public int getItemCount() {
        return movieListFiltered.size();
    }

    public void addItems(List<Movie> newMovies){
        this.mMovies.addAll(newMovies);
        this.notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    movieListFiltered = mMovies;
                } else {
                    List<Movie> filteredList = new ArrayList<>();
                    for (Movie row : mMovies) {

                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    movieListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = movieListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                movieListFiltered = (ArrayList<Movie>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private MovieItemBinding binding;

        public BindingHolder(MovieItemBinding binding) {
            super(binding.contactCard);
            this.binding = binding;
        }
    }
}
