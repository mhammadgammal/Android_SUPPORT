package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DayAdapter shoppingAdapter;
    List<String> weekList;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weekList =new ArrayList<>();
        recyclerView =findViewById(R.id.shoppingRV);
        data();
        shoppingAdapter=new DayAdapter();
        weekList =
        shoppingAdapter.setWeekList(weekList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(shoppingAdapter);


    }

    public void data(){
        int [] images={
                R.drawable.apple,
                R.drawable.dell1,
                R.drawable.lenovo,
                R.drawable.lenovo2,
                R.drawable.mini,
                R.drawable.razer,
                R.drawable.samsung
        };

        double [] price={
                30000,
                20000,
                15000,
                17000,
                14000,
                22000,
                25000
        };

        Resources res= getResources();
        String [] laptopNames=res.getStringArray(R.array.laptopNames);
        for(int i=0;i<7;i++){
            weekList.add(new ShoppingModel(images[i],laptopNames[i],price[i]));
        }

    }
}