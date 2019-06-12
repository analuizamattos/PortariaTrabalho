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
/*
    public boolean saveUsuario(Usuario usuario) {
        SQLiteDatabase db = this.writableDatabase;
        val values = ContentValues()
        values.put(FIRST_NAME, usuario.getNome())
        values.put(LAST_NAME, usuario.getSobrenome())
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }


    fun getAllUsers(): String {
        var allUser: String = "";
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getString(cursor.getColumnIndex(ID))
                    var firstName = cursor.getString(cursor.getColumnIndex(FIRST_NAME))
                    var lastName = cursor.getString(cursor.getColumnIndex(LAST_NAME))
                    allUser = "$allUser\n$id $firstName $lastName"
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allUser
    }*/


}
