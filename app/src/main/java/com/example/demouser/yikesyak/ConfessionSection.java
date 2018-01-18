package com.example.demouser.yikesyak;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ConfessionSection extends AppCompatActivity {

    private String postContent;
    private boolean complete;
    private EditText content = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compliments_main);
        content = (EditText) findViewById(R.id.content);
        getPostContent();
        addPost();
    }

    protected void addPost(){
        final Button postButton = findViewById(R.id.post);
        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView thisText = (TextView) findViewById(R.id.text);
                thisText.setText(postContent);
                final Post newPost = new Post(thisText, (TextView) findViewById(R.id.date), (TextView)findViewById(R.id.time),
                        (ImageButton) findViewById(R.id.upvote), (ImageButton)findViewById(R.id.downvote),
                        (ImageButton)findViewById(R.id.report),(TextView)findViewById(R.id.votes),(Button)findViewById(R.id.comments));
                ((ConstraintLayout)findViewById(R.id.includedLayout)).setVisibility(View.VISIBLE);
                complete=true;
            }
        });
    }

    protected void getPostContent(){

        content.addTextChangedListener(new TextWatcher() {
            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                postContent = c.toString();
                //setTitle(c.toString());
                if(complete) {
                    postContent = c.toString();
                    setTitle("");
                    content.setEnabled(false);
                }
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
            }
        });
    }

}