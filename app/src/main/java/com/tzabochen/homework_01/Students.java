package com.tzabochen.homework_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class Students extends AppCompatActivity
{
    // LAYOUT
    private static final int LAYOUT = R.layout.activity_students;

    // VIEW
    ListView studentsListView;

    // STUDENTS
    private String[] students;
    private ArrayList<String> getStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // STYLE
        setTheme(R.style.DefaultTheme);
        setContentView(LAYOUT);
        setTitle(R.string.students_title);

        // INITIALIZATION
        initView();
        initStudents();
        initAdapter();
    }

    // FIND VIEW
    private void initView()
    {
        this.studentsListView = (ListView) findViewById(R.id.students_list_view);
    }

    // INIT STUDENTS
    private void initStudents()
    {
        try
        {
            Users users = new Users();
            this.getStudents = users.getUsers(this, R.raw.students);
            this.students = getStudents.toArray(new String[getStudents.size()]);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // ADAPTER
    private void initAdapter()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_user, students);
        this.studentsListView.setAdapter(adapter);
    }
}