package com.example.demouser.yikesyak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private List<Post> postList;
    private List<Comment> commentList;

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public int getItemCount() {
        if(postList!=null) {
            return postList.size();
        }
        else{
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(PostHolder postHolder, int i) {
        Post post = postList.get(i);
        //Set the text of the feed with your data
        postHolder.feedText.setText((CharSequence) post.text);
        postHolder.feedText.setTypeface(postHolder.feedText.getTypeface(), Typeface.BOLD);
        postHolder.dateText.setText(post.date);
        postHolder.voteNum.setText(String.valueOf(post.votes));
        postHolder.dateText.setText((CharSequence) post.date);
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.postlayout, viewGroup, false);
        return new PostHolder(itemView);
    }

    public static class PostHolder extends RecyclerView.ViewHolder {
        private TextView feedText;
        private TextView dateText;
        private ImageButton upText;
        private ImageButton downText;
        private TextView voteNum;
        private Button commentsButton;
        private ImageButton reportButton;

        private PostHolder(View v) {
            super(v);
            feedText = (TextView) v.findViewById(R.id.text);
            dateText = (TextView) v.findViewById(R.id.date);
            upText = (ImageButton) v.findViewById(R.id.upvote);
            downText = (ImageButton) v.findViewById(R.id.downvote);
            voteNum = (TextView) v.findViewById(R.id.votes);
            commentsButton = (Button) v.findViewById(R.id.comments);
            reportButton = (ImageButton) v.findViewById(R.id.report);
            vote();
            commentsButton();
            reportButton();
        }

        private void vote() {
            voteNum.setText("0");
            upText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int current = Integer.parseInt(voteNum.getText().toString());
                    current++;
                    voteNum.setText(Integer.toString(current));
                }
            });
            downText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int current = Integer.parseInt(voteNum.getText().toString());
                    current--;
                    voteNum.setText(Integer.toString(current));
                }
            });
        }

        private void commentsButton() {
            final Button button = commentsButton;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Context con = v.getContext();
                    Class current = getClass();
                    if(current==ComplimentsSection.class) {
                        Intent intent = new Intent(v.getContext(), CommentsSection.class);
                        con.startActivity(intent);
                    }
                    else if(current==ConfessionSection.class) {
                        Intent intent = new Intent(v.getContext(), CommentsConfesh.class);
                        con.startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(v.getContext(), CommentsQA.class);
                        con.startActivity(intent);
                    }
                }
            });
        }

        private void reportButton() {
            final ImageButton button = reportButton;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String emails [] = {"altha22n@mtholyoke.edu", "gomez22n@mtholyoke.edu",
                            "tucks22e@mtholyoke.edu", "wang225y@mtholyoke.edu"};
                    Intent intent = new Intent (Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, emails);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "Reason for Reporting");
                    v.getContext().startActivity(intent);
                }

            });
        }
    }

}
