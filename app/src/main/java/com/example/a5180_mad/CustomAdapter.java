package com.example.a5180_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Assignment> {

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Assignment> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_layout, parent, false);
        }

        Assignment assignment = getItem(position);

        TextView title = convertView.findViewById(R.id.textViewTitle);
        TextView description = convertView.findViewById(R.id.textViewDescription);

        title.setText(assignment.name);
        description.setText(assignment.description);

        return convertView;
    }
}
