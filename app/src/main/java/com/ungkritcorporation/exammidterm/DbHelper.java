package com.ungkritcorporation.exammidterm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Windows 8.1 on 2/3/2560.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String databaseName = "todolist.sqlite";
    private static final int databaseVersion = 1;
    private static final String tableCreateSql = "create table todo_list(" +
            "id integer primary key autoincrement," +
            "todo_text TEXT , " +
            " todo_text1 TEXT "+
            ");";
    Context myContext;

    public DbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreateSql);
        String insertData1 = "insert into todo_list (todo_text,todo_text1) values ('NuanSri','089-123-1234');";
        String insertData2 = "insert into todo_list (todo_text,todo_text1) values ('Wantana','089-098-7654');";
        String insertData3 = "insert into todo_list (todo_text,todo_text1) values ('Pongpon','089-123-7654');";
        db.execSQL(insertData1);
        db.execSQL(insertData2);
        db.execSQL(insertData3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
