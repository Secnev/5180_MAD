package com.example.a5180_mad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    CustomAdapter adapter;
    ListView listView;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#255C27"));
        actionBar.setBackgroundDrawable(colorDrawable);
        setTitle("Course Apps");

        //Add assignments to assignments ArrayList
        assignments.add(new Assignment("In Class Assignment 2: Ticket Price Discount ", "This app takes in a ticket price, lets the user choose a discount percentage and then calculates the discounted price."));//0

        listView = findViewById(R.id.listViewMain);
        adapter = new CustomAdapter(this, 0, assignments);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: Intent intent = new Intent(MainActivity.this, TicketPriceMainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });



    }
}