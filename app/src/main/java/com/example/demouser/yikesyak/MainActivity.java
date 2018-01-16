package com.example.demouser.yikesyak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Queue<Post> postQ;
    private PostNode<Post> head;
    private PostNode<Post> tail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPost();

    }

    class PostNode<Post> {
        Post post;
        PostNode<Post> next;

        public void setNext(PostNode<Post> node) {
            next = node;
        }
    }

    private void addPost(Post p){
        postQ = new LinkedList<Post>();
        if (postQ.isEmpty()) {
            this.head = new Post();
            postQ.add(this.head);
        } else {
            // If tail is null, this is the second element
            if (this.tail == null) {
                //this.tail = new PostNode<Post>(p, null);
                this.head.setNext(this.tail);
            } else {

                PostNode<Post> previousTail = this.tail;
                //PostNode<Post> newTail = new PostNode<Post>(p, null);
                previousTail.setNext(newTail);
                this.tail = newTail;
                postQ.add(this.tail);
            }
        }




    }




    //displaying the posts
    private void showPost(){
        if(postQ.isEmpty()){
            return;
            //print there are no posts to show
        }
        else{
            postQ.peek();
        }
    }
}
