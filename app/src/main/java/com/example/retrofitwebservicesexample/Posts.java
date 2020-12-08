package com.example.retrofitwebservicesexample;

import com.google.gson.annotations.SerializedName;

public class Posts {
    /*private int userId;
    private int id;
    private String title;
    @SerializedName("body")//suppose to be the body value of app
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }*/
    private int date;
    private int positive;
    private int negative;
    private int recovered;
    private int death;

    public int getDate() {
        return date;
    }

    public int getPositive() {
        return positive;
    }

    public int getNegative() {
        return negative;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getDeath() {
        return death;
    }
}
