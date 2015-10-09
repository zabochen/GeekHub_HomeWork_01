package com.tzabochen.homework_01;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Users
{
    public ArrayList<String> getUsers(Context context, int resId) throws IOException
    {
        // VALUES
        ArrayList<String> usersList = new ArrayList<>();
        String getUser;

        // READ FILE
        InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(resId));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // ARRAY LIST CONTENT
        while((getUser = bufferedReader.readLine()) != null)
        {
            usersList.add(getUser);
        }

        // SORT
        Collections.sort(usersList);

        return usersList;
    }
}
