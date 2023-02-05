package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ShoppingAdapter shoppingAdapter;
    private List<ShoppingModelImpl> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.shoppingRV);
        data();
        ShoppingAdapter.OnProductClickListener listener = new ShoppingAdapter.OnProductClickListener() {
            @Override
            public void onProductClickListener(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        };
        shoppingAdapter = new ShoppingAdapter(this, listener);
        shoppingAdapter.setData(productList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(shoppingAdapter);
    }

    public void data() {
        int[] images = {
                R.drawable.apple,
                R.drawable.dell1,
                R.drawable.lenovo,
                R.drawable.lenovo2,
                R.drawable.mini,
                R.drawable.razer,
                R.drawable.samsung
        };

        double[] price = {
                30000,
                20000,
                15000,
                17000,
                14000,
                22000,
                25000
        };

        Resources res = getResources();
        String[] laptopNames = res.getStringArray(R.array.laptopNames);
        for (int i = 0; i < 7; i++) {
            productList.add(new ShoppingModelImpl(images[i], laptopNames[i], price[i]));
        }

    }
}