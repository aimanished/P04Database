package com.example.a16031940.p04database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskArrayAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvDescription;
    private TextView tvDate;
    private ListView lv;


    public TaskArrayAdapter(Context context, int resource,ArrayList<Task> objects) {
        super(context, resource, objects);
        tasks = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row,parent,false);
        Task currentTasks = tasks.get(position);
        tvDescription = (TextView)rowView.findViewById(R.id.textView);
        lv = rowView.findViewById(R.id.lv);
        tvDate = rowView.findViewById(R.id.textView2);
        String Date = currentTasks.getDate().toString();
        String Description = currentTasks.getDescription().toString();
        tvDate.setText(Date);
        tvDescription.setText(Description);

        return rowView;
    }
}
