package com.arctouch.pablo.tmdb.service.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo.
 */

@Parcel
public class Genre {


    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Genre)obj).getId() == this.getId();
    }

    @Override
    public String toString() {
        return getName();
    }
}
