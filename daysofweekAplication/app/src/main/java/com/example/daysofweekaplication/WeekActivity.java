package com.example.daysofweekaplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class WeekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        Objects.requireNonNull(getSupportActionBar()).setTitle(userName);
        RecyclerView daysRV = findViewById(R.id.daysRV);
        DaysAdapter adapter = new DaysAdapter();
        daysRV.setAdapter(adapter);
    }
}