package com.example.demouser.yikesyak;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

        public PostHolder(View v) {
            super(v);
            feedText = (TextView) v.findViewById(R.id.text);
            dateText = (TextView) v.findViewById(R.id.date);
        }
    }
}


