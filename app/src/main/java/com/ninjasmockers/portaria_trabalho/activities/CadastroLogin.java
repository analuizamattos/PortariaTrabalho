package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ninjasmockers.portaria_trabalho.R;

public class CadastroLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);
    }
        protected void criar(View view){
            startActivity(new Intent(this,MainActivity.class));
        }

    protected void cancelar(View view){
        startActivity(new Intent(this,MainActivity.class));

    }
}
