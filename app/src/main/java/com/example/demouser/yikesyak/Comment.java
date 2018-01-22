package com.example.demouser.yikesyak;

import java.util.ArrayList;

/**
 * Created by demouser on 1/19/18.
 */

public class Comment {

    public String text;
    public String date;
    public int votes;

    public Comment(String text, String date, int votes){
        this.text = text;
        this.date = date;
        this.votes = votes;
    }
}
