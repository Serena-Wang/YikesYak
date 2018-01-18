package com.example.demouser.yikesyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    private Button confessional,QA,compliments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_main);

        //Setting up the buttons
        confessional = (Button)findViewById(R.id.button5);
        QA = (Button)findViewById(R.id.button6);
        compliments = (Button)findViewById(R.id.button7);

        //Set the on click listeners for the buttons
        confessional.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), ConfessionSection.class);
                startActivity(intent);
            }
        });

        QA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), QASection.class);
                startActivity(intent);
            }
        });

        compliments.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), ComplimentsSection.class);
                startActivity(intent);
            }
        });
    }


}
