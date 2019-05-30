package com.ninjasmockers.portaria_trabalho.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DICTIONARY_TABLE_NAME = "usuario";
    private static final String KEY_WORD = "id";
    private static final String KEY_DEFINITION = "nome";
    private static final String DICTIONARY_TABLE_CREATE = ("CREATE TABLE " +
            DICTIONARY_TABLE_NAME + " (" +
            KEY_WORD  + " TEXT, " +
            KEY_DEFINITION + " TEXT);");

    public DBHelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
