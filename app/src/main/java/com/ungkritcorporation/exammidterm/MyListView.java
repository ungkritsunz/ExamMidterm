package com.ungkritcorporation.exammidterm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Windows 8.1 on 2/3/2560.
 */

public class MyListView extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<ToDoList> myTodolist;

    public MyListView(Activity activity,ArrayList<ToDoList> myTodolist) {
        this.myTodolist = myTodolist;
        this.activity = activity;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return myTodolist.size();
    }

    @Override
    public Object getItem(int position) {
        return myTodolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myTodolist.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.my_list_layout,null);
        TextView textView = (TextView) v.findViewById(R.id.listview_text);
        ToDoList toDoList = myTodolist.get(position);
        textView.setText(toDoList.getText());

        TextView textView1 = (TextView) v.findViewById(R.id.listview_text1);
        ToDoList toDoList1 = myTodolist.get(position);
        textView1.setText(toDoList1.getText1());
        return v;
    }
}
