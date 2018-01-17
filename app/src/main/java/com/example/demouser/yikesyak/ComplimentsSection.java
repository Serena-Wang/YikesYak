package com.example.demouser.yikesyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ComplimentsSection extends AppCompatActivity {
    public Button home;
    public String TAG = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compliments_main);
        home = (Button) findViewById(R.id.button3);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "click");

                Intent intent = new Intent(view.getContext(), HomePage.class);
                startActivity(intent);

            }
        });
    }
}
