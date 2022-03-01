package com.example.a5180_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TaskCustomAdapter extends ArrayAdapter<Task> {
    Context mContext;
    List<Task> tasks;

    public TaskCustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.mContext = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.task_list_layout, parent, false);
        }

        Task task = getItem(position);

        TextView taskName =  convertView.findViewById(R.id.textViewListViewTaskName);
        taskName.setText(task.name);

        return convertView;
    }


}
