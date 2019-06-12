package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.dao.helpers.DBHelper;
import com.ninjasmockers.portaria_trabalho.entity.Usuario;

public class CadastroLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBHelper banco = new DBHelper(this, null,  null, 1, null);
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("joaozinho");
        usuario.setSobrenome("sobrenome né :D");

        boolean saved = banco.save(usuario);
        Log.i("saved", String.valueOf(saved));

        String result = banco.getAllUsers();
        Log.i("result", result);

        setContentView(R.layout.activity_cadastro_login);
    }
    
    protected void criar(View view){
        //startActivity(new Intent(this,MainActivity.class));
    }

    protected void cancelar(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
