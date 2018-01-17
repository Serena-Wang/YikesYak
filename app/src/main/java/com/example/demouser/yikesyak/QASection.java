package com.example.demouser.yikesyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QASection extends AppCompatActivity {
public Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qasection_main);



        home = (Button) findViewById(R.id.button3);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), HomePage.class);
                startActivity(intent);

            }
        });
    }
}
