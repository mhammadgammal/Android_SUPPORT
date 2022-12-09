package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LaptopInfo extends AppCompatActivity {
    Bundle extras;
    ImageView laptopImage;
    TextView laptopNameTV,laptopDesTV,laptopColorTV,laptopPriceTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_info);
    }
}