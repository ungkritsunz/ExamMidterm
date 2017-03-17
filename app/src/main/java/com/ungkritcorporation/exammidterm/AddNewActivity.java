package com.ungkritcorporation.exammidterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        final EditText newtodolist = (EditText) findViewById(R.id.addNewTask);
        final EditText newtodolist1 = (EditText) findViewById(R.id.addNewTask1);
        final Button newtodolistbtn = (Button) findViewById(R.id.btnAddNewTask);

        newtodolistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoList todolist = new ToDoList();
                //ToDoList todolist1 = new ToDoList();

                todolist.setText(String.valueOf(newtodolist.getText()));
                todolist.setText1(String.valueOf(newtodolist1.getText()));

                TodolistDao todolistdao = new TodolistDao(getApplicationContext());
                todolistdao.open();
                todolistdao.add(todolist);
//                todolistdao.add(todolist1);
                todolistdao.close();
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.addnew){
            Intent addnewintent = new Intent(this,AddNewActivity.class);
            startActivity(addnewintent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
