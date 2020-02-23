package com.example.recetarioapplication.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbConnection extends SQLiteOpenHelper {


    public dbConnection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creamos la base de datos
        db.execSQL(dbUtility.CREATE_TABLA_RECETAS );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          //le decimos que si encuentra una versiona antigua instalada la quite y la cree otra vez
        db.execSQL("drop table if exists recetas");
        onCreate(db);
    }
}
