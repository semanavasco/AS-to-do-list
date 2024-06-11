package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> tasks;

    public TaskAdapter(Context context, ArrayList<String> tasks) {
        super(context, R.layout.list_item, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView taskItem = convertView.findViewById(R.id.task_item);
        taskItem.setText(tasks.get(position));

        ImageButton removeTaskButton = convertView.findViewById(R.id.remove_task);
        removeTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
