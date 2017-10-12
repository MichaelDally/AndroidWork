package com.dummies.tasks.activity;

import android.os.Bundle;
import android.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;




public class TaskEditActivity extends AppCompatActivity {
    public static final String EXTRA_TASKID = "taskID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);
        setActionBar((Toolbar) findViewById(R.id.toolbar));
    }

}
