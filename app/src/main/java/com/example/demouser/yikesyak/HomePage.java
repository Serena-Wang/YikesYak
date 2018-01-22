package com.example.demouser.yikesyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    public Button confessional, QA, compliments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_main);

        confessional = (Button) findViewById(R.id.button5);
        confessional.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), ConfessionSection.class);
                startActivity(intent);

            }

        });
        QA =(Button) findViewById(R.id.button6);
        QA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), QASection.class);
                startActivity(intent);

            }

        });


        compliments =(Button) findViewById(R.id.button7);
        compliments.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), ComplimentsSection.class);
                startActivity(intent);

            }

        });



    }


}
