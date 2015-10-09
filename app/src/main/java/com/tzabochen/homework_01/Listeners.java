package com.tzabochen.homework_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class Listeners extends AppCompatActivity
{
    // LAYOUT
    private static final int LAYOUT = R.layout.activity_listeners;

    // VIEW
    private ListView listenersListView;

    // LISTENERS
    private String[] listeners;
    private ArrayList<String> getListeners;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // STYLE
        setTheme(R.style.DefaultTheme);
        setContentView(LAYOUT);
        setTitle(R.string.listeners_title);

        // INITIALIZATION
        initView();
        initListeners();
        initAdapter();
    }

    // FIND VIEW
    private void initView()
    {
        this.listenersListView = (ListView) findViewById(R.id.listeners_list_view);
    }

    // INIT LISTENERS
    private void initListeners()
    {
        try
        {
            Users users = new Users();
            this.getListeners = users.getUsers(this, R.raw.listeners);
            this.listeners = getListeners.toArray(new String[getListeners.size()]);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initAdapter()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_user, listeners);
        this.listenersListView.setAdapter(adapter);
    }
}