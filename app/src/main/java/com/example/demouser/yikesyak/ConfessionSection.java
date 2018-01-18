package com.example.demouser.yikesyak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConfessionSection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confession_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
