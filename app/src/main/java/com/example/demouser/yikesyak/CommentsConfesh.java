package com.example.demouser.yikesyak;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demouser on 1/19/18.
 */

public class CommentsConfesh extends AppCompatActivity {
    private RecyclerView recList;
    private List<Post> list;
    private ArrayList<Comment> commentsList;
    private TextView subEditText;
    private PostAdapter pa;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("MSG", "HI");
        setContentView(R.layout.comments_main);
        //Declares the view for your feed
        list = new ArrayList<Post>();
        commentsList = new ArrayList<Comment>();
        //Set the layout and the RecyclerView
        recList = (RecyclerView) findViewById(R.id.commentList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        pa = new PostAdapter(list);
        //Set the adapter for the recyclerlist
        recList.setAdapter(pa);
        addComment();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void addComment(){
        final Button postButton = findViewById(R.id.comment);
        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.comment:
                        openDialog();
                }
            }
        });

    }

    //Method to open the dialog to post a feed
    private void openDialog(){
        LayoutInflater inflater = LayoutInflater.from(CommentsConfesh.this);
        View subView = inflater.inflate(R.layout.dialog, null);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(subView);
        //Build the AlertDialog.
        AlertDialog alertDialog = builder.create();
        subEditText = (EditText)subView.findViewById(R.id.dialogEditText);

        builder.setPositiveButton("YIKES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String text = subEditText.getText().toString();

                long dateText = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm a");
                String date = sdf.format(dateText);
                //Post post = new Post(text, date, 0, commentsList);
                Post post = new Post(text, date, 0, commentsList);
                //Add data to the list
                list.add(post);
                //Notify the Adapter so that you can see the changes.
                pa.notifyDataSetChanged();
                //Scroll the RecyclerView to the bottom.
                recList.smoothScrollToPosition(pa.getItemCount());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //This will close the Dialog
            }
        });

        builder.show();
    }
}
