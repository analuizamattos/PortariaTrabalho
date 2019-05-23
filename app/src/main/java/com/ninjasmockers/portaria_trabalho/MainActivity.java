package com.ninjasmockers.portaria_trabalho;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Preferencias preferencias;
    private TextView nome ;
    private TextInputEditText nomeDigitado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias = new Preferencias(getApplicationContext());
        nome = findViewById(R.id.textViewNome);




        String valor = preferencias.recuperaAnotacao();
        nome.setText(valor);

    }



    protected void cadastroLogin(View view){
        startActivity(new Intent(this,CadastroLogin.class));
    }
    public void goHome(View view){
        nomeDigitado = findViewById(R.id.TextInputNome);
        preferencias.salvarAnotacao(nomeDigitado.getText().toString());
        startActivity(new Intent(this,Home.class));



    }




    }


