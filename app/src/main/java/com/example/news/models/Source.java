package com.example.news.models;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    public Object id;
    @SerializedName("name")
    public String name;

    public Object getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
