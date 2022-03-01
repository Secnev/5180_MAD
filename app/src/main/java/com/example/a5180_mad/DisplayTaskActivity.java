package com.example.a5180_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayTaskActivity extends AppCompatActivity {
    String TAG = "5180";
    TextView textViewDisplayName;
    TextView textViewDisplayDate;
    TextView textViewDisplayPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_task);
        textViewDisplayName = findViewById(R.id.textViewDisplayTaskName);
        textViewDisplayDate = findViewById(R.id.textViewDisplayTaskDate);
        textViewDisplayPriority = findViewById(R.id.textViewDisplayTaskPriority);

        try{
            //Get data extra from intent
            Task task = (Task) getIntent().getSerializableExtra(Hw02MainActivity.TASK_KEY);
            textViewDisplayName.setText(task.name);
            textViewDisplayDate.setText(task.dateString);
            textViewDisplayPriority.setText(task.priority);
        } catch (Exception e){
            Log.d(TAG, "Exception: "+e);
        }

        //Button - Delete
        findViewById(R.id.buttonDisplayTaskDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        //Button - Cancel
        findViewById(R.id.buttonDisplayTaskCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}