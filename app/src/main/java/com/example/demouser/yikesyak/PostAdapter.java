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
        if(postList!=null) {
            return postList.size();
        }
        return 0;
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
        protected TextView feedText;
        protected TextView dateText;
        protected ImageButton upText;
        protected ImageButton downText;
        protected TextView voteNum;
        protected Button commentsButton;
        protected ImageButton reportButton;

        public PostHolder(View v) {
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
            upText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!voteNum.getText().equals("")) {
                        int current = Integer.parseInt(voteNum.getText().toString());
                        current++;
                        voteNum.setText(Integer.toString(current));
                    } else {
                        voteNum.setText(Integer.toString(1));
                    }
                }
            });
            downText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!voteNum.getText().equals("")) {
                        int current = Integer.parseInt(voteNum.getText().toString());
                        current--;
                        voteNum.setText(Integer.toString(current));
                    } else {
                        voteNum.setText(Integer.toString(1));
                    }
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


