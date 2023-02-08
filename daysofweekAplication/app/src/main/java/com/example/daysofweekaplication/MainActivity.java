package com.example.daysofweekaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.daysofweekaplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText firstName, famName, age;
    Button goBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.firstNameTV);
        famName = findViewById(R.id.famNameTV);
        age = findViewById(R.id.ageTV);
        goBTN = findViewById(R.id.goBTN);
        goBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToWeekActivity();
            }
        });
    }

    private void navToWeekActivity(){
        Intent intent = new Intent(MainActivity.this, WeekActivity.class);
        intent.putExtra("name",
          firstName.getText().toString() + " " + famName.getText().toString());
        startActivity(intent);
    }
}