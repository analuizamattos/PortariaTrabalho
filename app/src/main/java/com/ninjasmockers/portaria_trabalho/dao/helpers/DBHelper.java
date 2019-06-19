package com.ninjasmockers.portaria_trabalho.dao.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ninjasmockers.portaria_trabalho.entity.Usuario;

public class DBHelper extends SQLiteOpenHelper {
    private static final String USUARIO = "usuario";
    private static final String NOME = "nome";
    private static final String SENHA = "senha";
    private static final String DICTIONARY_TABLE_CREATE = "CREATE TABLE usuario(nome TEXT, senha TEXT);";

    public DBHelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE usuario;");
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean save(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, usuario.getNome());

        long success = db.insert(USUARIO, null, values);
        db.close();
        return success != -1L;
    }


    public String getAllUsers() {
        StringBuilder allUser = new StringBuilder();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuario", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String nome = cursor.getString(cursor.getColumnIndex(NOME));
                    String senha = cursor.getString(cursor.getColumnIndex(SENHA));
                    allUser.append(";nome: ");
                    allUser.append(nome);
                    allUser.append(";senha: ");
                    allUser.append(senha);
                    allUser.append("\n");
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return allUser.toString();
    }


}

