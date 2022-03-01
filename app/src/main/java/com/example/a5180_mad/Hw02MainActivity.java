package com.example.a5180_mad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Hw02MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();
    TaskCustomAdapter adapter;
    public static String TASK_KEY = "TASK_KEY";
    int chosenTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw02_main);
        tasks.add(new Task("Task 1", "00/00/00", "priority"));
        tasks.add(new Task("Task 2", "00/00/00", "priority"));
        adapter = new TaskCustomAdapter(this, 0, tasks);


        //Button - View Tasks
        findViewById(R.id.buttonViewTasks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Hw02MainActivity.this);
                builder.setTitle("Tasks")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        chosenTask = i;
                        Intent displayTaskIntent = new Intent(Hw02MainActivity.this, DisplayTaskActivity.class);
                        displayTaskIntent.putExtra(TASK_KEY, tasks.get(i));
                        startActivity(displayTaskIntent);
                    }
                });

                builder.create().show();
            }
        });
        //Button - Create Task
        findViewById(R.id.buttonCreateTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}