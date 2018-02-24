package com.arctouch.pablo.tmdb.service.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo.
 */

@Parcel
public class Movie {

    public static String  IMAGE_URL = "http://image.tmdb.org/t/p/w300";

    @SerializedName("id")
    int id;
    @SerializedName("vote_average")
    double voteAverage;
    @SerializedName("title")
    String title;
    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("backdrop_path")
    String backdropPath;
    @SerializedName("genre_ids")
    List<Integer> genreIds = new ArrayList<>();
    @SerializedName("release_date")
     String releaseDate;
    @SerializedName("overview")
    String overview;

    List<Genre> genres = new ArrayList<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return IMAGE_URL + posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return  IMAGE_URL + backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getGenresNames(){
        return this.genres.toString().replace("[","").replace("]","");
    }

    public void updateGenre(List<Genre> genres){
        for ( int genreId : this.getGenreIds()) {

            Genre auxGenre = new Genre();
            auxGenre.setId(genreId);
            int genreIndex = genres.indexOf(auxGenre);
            if(genreIndex >= 0){
                this.getGenres().add( genres.get(genreIndex));
            }


        }
    }
}
