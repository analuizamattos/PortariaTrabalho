package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ninjasmockers.portaria_trabalho.R;

public class CadastroVisitante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_visitante);
    }
    protected void home(View view){ startActivity(new Intent(this,Home.class));
    }
}
