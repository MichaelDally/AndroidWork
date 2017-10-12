package com.dummies.tasks.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.dummies.tasks.interfaces.OnEditTask;

public class TaskListActivity extends AppCompatActivity implements OnEditTask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        setActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    @Override
    public void editTask(long id) {
        //When we are asked to edit or insert a task, start the TaskEditActivity with the id of the task to edit
        startActivity(new Intent(this, TaskEditActivity.class).putExtra(TaskEditActivity.EXTRA_TASKID, id));
    }
}
