package com.example.demouser.yikesyak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QASection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qasection_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
