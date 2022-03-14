package com.nathit.gsonsimple.model;

import com.google.gson.annotations.SerializedName;

public class userModel {

    private String mLine1;
    private String mLine2;

    public userModel(String Line1, String Line2) {
        this.mLine1 = Line1;
        this.mLine2 = Line2;
    }

    public String getLine1() {
        return mLine1;
    }

    public String getLine2() {
        return mLine2;
    }
}
