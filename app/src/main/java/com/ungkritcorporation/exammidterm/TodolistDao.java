package com.ungkritcorporation.exammidterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Windows 8.1 on 2/3/2560.
 */

public class TodolistDao {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodolistDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase(); //เปิดมาแก้ไข
    }
    public void close(){
        dbHelper.close();
    }
    public ArrayList<ToDoList> getAllToDoList() {
        ArrayList<ToDoList> todolist = new ArrayList<ToDoList>();
        Cursor cursor = database.rawQuery("select * from todo_list;",null);
        cursor.moveToFirst();
        ToDoList todolist1;
        while (!cursor.isAfterLast()) {
            todolist1 = new ToDoList();
            todolist1.setId(cursor.getInt(0));
            todolist1.setText(cursor.getString(1));
            todolist1.setText1(cursor.getString(2));
            todolist.add(todolist1);
//        todolist.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return todolist;
    }
    public void add(ToDoList todolist){
        ToDoList newtodolist = new ToDoList();
        newtodolist = todolist;

        ContentValues values = new ContentValues();
        values.put("todo_text",newtodolist.getText());
        values.put("todo_text1",newtodolist.getText1());
        this.database.insert("todo_list",null,values);

        Log.d("todolist demo","add text ok");
    }
}
