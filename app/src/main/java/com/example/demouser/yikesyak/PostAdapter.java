package com.example.demouser.yikesyak;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
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

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public void onBindViewHolder(PostHolder postHolder, int i) {
        Post post = postList.get(i);
        //Set the text of the feed with your data
        postHolder.feedText.setText(post.text);
        postHolder.feedText.setTypeface(postHolder.feedText.getTypeface(), Typeface.BOLD);
        postHolder.dateText.setText(post.date);
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

        private void holdButton() {
            final Button button = commentsButton;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {


                }
            });
        }

        private void reportButton() {
            final ImageButton button = reportButton;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });
        }
    }

}


