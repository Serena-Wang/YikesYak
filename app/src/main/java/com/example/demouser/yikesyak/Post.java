package com.example.demouser.yikesyak;

import android.content.Context;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by demouser on 1/16/18.
 */

public class Post{

    private EditText text;
    private TextView date;
    private TextView time;
    private ImageButton upvote;
    private ImageButton downvote;
    private ImageButton report;
    private TextView votes;
    private Button comments;

    public Post(EditText text, TextView date, TextView time, ImageButton upvote, ImageButton downvote, ImageButton report,
                TextView votes, Button comments) {
        this.text = text;
        this.date = date;
        this.time = time;
        this.upvote = upvote;
        this.downvote = downvote;
        this.report = report;
        this.votes = votes;
        this.comments = comments;
    }

    private void holdButton(){
        final Button button = comments;

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });
    }

    private void reportButton(){
        final ImageButton button = report;

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

    private void vote(){
        final ImageButton upvote = this.upvote;
        final ImageButton downvote = this.downvote;
        upvote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int current = Integer.parseInt(votes.getText().toString());
                votes.setText(current++);
            }
        });
        downvote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int current = Integer.parseInt(votes.getText().toString());
                votes.setText(current--);
            }
        });
    }

}
