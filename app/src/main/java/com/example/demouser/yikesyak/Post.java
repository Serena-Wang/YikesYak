package com.example.demouser.yikesyak;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Represents a text post.
 */
public class Post {

    public String text;
    public String date;
    public int votes;
    public ArrayList<Comment> comments;

    public Post(String text, String date, int votes, ArrayList<Comment> comments){
        this.text = text;
        this.date = date;
        this.votes = votes;
        this.comments = comments;
    }

}



