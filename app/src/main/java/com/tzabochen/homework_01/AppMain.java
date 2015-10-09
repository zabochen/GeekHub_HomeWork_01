package com.tzabochen.homework_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AppMain extends AppCompatActivity implements View.OnClickListener
{
    // LAYOUT
    private static final int LAYOUT = R.layout.activity_main;

    // VIEW
    private Button buttonStudents;
    private Button buttonListeners;

    // INTENT
    private Intent intent;
    private String intentStudents  = "com.tzabochen.students";
    private String intentListeners = "com.tzabochen.listeners";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // STYLE
        setTheme(R.style.DefaultTheme);
        setContentView(LAYOUT);

        // INITIALIZATION
        initView();
        initListener();
    }

    // FIND VIEW
    private void initView()
    {
        this.buttonStudents = (Button) findViewById(R.id.main_button_students);
        this.buttonListeners = (Button) findViewById(R.id.main_button_listeners);
    }

    // LISTENERS
    @Override
    public void onClick(View view)
    {
        if (view.equals(buttonStudents))
        {
            this.intent = new Intent(intentStudents);
            startActivity(intent);
            return;
        }
        else if (view.equals(buttonListeners))
        {
            this.intent = new Intent(intentListeners);
            startActivity(intent);
            return;
        }
    }

    // INIT LISTENER
    private void initListener()
    {
        this.buttonStudents.setOnClickListener(this);
        this.buttonListeners.setOnClickListener(this);
    }
}