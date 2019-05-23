package com.ninjasmockers.portaria_trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    protected void inserir(View view){
        startActivity(new Intent(this,CadastroVisitante.class));
    }
    protected void sair(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
