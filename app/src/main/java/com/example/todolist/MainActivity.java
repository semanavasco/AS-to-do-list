package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText taskInput;
    ListView taskList;

    ArrayList<String> tasks;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.task_input);
        taskList = findViewById(R.id.task_list);

        tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, tasks);
        taskList.setAdapter(taskAdapter);
    }

    public void addTask(View view) {
        String task = taskInput.getText().toString();
        if (!task.isEmpty()) {
            tasks.add(task);
            taskAdapter.notifyDataSetChanged();
            taskInput.setText("");
        }
    }
}
