package com.example.demouser.yikesyak;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Comment;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ComplimentsSection extends AppCompatActivity {

    private RecyclerView recList;
    private List<Post> list;
    private TextView subEditText;
    private ArrayList<com.example.demouser.yikesyak.Comment> commentsList;
    private PostAdapter pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.compliments_main);

        //Declares the view for your feed

        SharedPreferences settings = getSharedPreferences(getString(R.string.PrefsFile), 0);
        Gson gson = new Gson();
        String json = settings.getString(getString(R.string.CompPostsKey), "");
        Type type = new TypeToken<List<Post>>(){}.getType();
        if (gson.fromJson(json, type) != null) {
            list = gson.fromJson(json, type);
        }
        else{
            list = new ArrayList<>();
            commentsList = new ArrayList<com.example.demouser.yikesyak.Comment>();
        }
        //Set the layout and the RecyclerView
        recList = (RecyclerView) findViewById(R.id.postList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        recList.setLayoutManager(llm);
        pa = new PostAdapter(list);
        //Set the adapter for the recyclerlist
        recList.setAdapter(pa);
        addPost();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    protected void addPost(){
        final Button postButton = findViewById(R.id.post);
        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.post:
                        openDialog();
                }
            }
        });

    }

    //Method to open the dialog to post a feed
    private void openDialog(){
        LayoutInflater inflater = LayoutInflater.from(ComplimentsSection.this);
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

                Post post = new Post(text, date, 0, commentsList);

                //Add data to the list
                list.add(post);

                SharedPreferences settings = getSharedPreferences(getString(R.string.PrefsFile), 0);
                Gson gson = new Gson();
                String json = gson.toJson(list);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(getString(R.string.CompPostsKey),json);
                editor.apply();
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