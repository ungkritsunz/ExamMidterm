package com.ungkritcorporation.exammidterm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView todoListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        todoListView = (ListView) findViewById(R.id.todoListView);

        TodolistDao todolistdao = new TodolistDao(getApplicationContext());
        todolistdao.open();
//        ArrayList<String> myList = todolistdao.getAllToDoList();
        ArrayList<ToDoList> myList = todolistdao.getAllToDoList();
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        MyListView adapter = new MyListView(this,myList);
        todoListView.setAdapter(adapter);
        todolistdao.close();
    }
    @Override
    protected void onResume() {
        TodolistDao todolistdao = new TodolistDao(getApplicationContext());
        todolistdao.open();
//        ArrayList<String> myList = todolistdao.getAllToDoList();
        ArrayList<ToDoList> myList = todolistdao.getAllToDoList();
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        MyListView adapter = new MyListView(this,myList);
        todoListView.setAdapter(adapter);
        todolistdao.close();
        super.onResume();
    }

}
