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
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Represents a text post.
 */
public class Post {

    private TextView text;
    private String thisText;
    private TextView date;
    private TextView time;
    private ImageButton upvote;
    private ImageButton downvote;
    private ImageButton report;
    private TextView votes;
    private Button comments;

/*    public Post(String thisText, TextView date, TextView time, ImageButton upvote, ImageButton downvote, ImageButton report,
                TextView votes, Button comments) {
        this.thisText = thisText;
        this.date = date;
        this.time = time;
        this.upvote = upvote;
        this.downvote = downvote;
        this.report = report;
        this.votes = votes;
        this.comments = comments;
        vote();
    }*/

    public Post(TextView text, TextView date, TextView time, ImageButton upvote, ImageButton downvote, ImageButton report,
                TextView votes, Button comments) {
        this.text = text;
        this.date = date;
        this.time = time;
        this.upvote = upvote;
        this.downvote = downvote;
        this.report = report;
        this.votes = votes;
        this.comments = comments;
        vote();
    }

    private void holdButton() {
        final Button button = comments;

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });
    }

    private void reportButton() {
        final ImageButton button = report;

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

    private void vote() {
        final ImageButton upvote = this.upvote;
        final ImageButton downvote = this.downvote;
        upvote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!votes.getText().equals("")) {
                    int current = Integer.parseInt(votes.getText().toString());
                    current++;
                    votes.setText(Integer.toString(current));
                } else {
                    votes.setText(Integer.toString(1));
                }
            }
        });
        downvote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!votes.getText().equals("")) {
                    int current = Integer.parseInt(votes.getText().toString());
                    current--;
                    votes.setText(Integer.toString(current));
                } else {
                    votes.setText(Integer.toString(1));
                }
            }
        });
    }

}
