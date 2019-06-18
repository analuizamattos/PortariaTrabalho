package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.config.Configuracaofirebase;

public class Telainicial extends AppCompatActivity {
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        verificarUsuarioLogado();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_telainicial);
    }
    public void verificarUsuarioLogado(){
        autenticacao = Configuracaofirebase.getAutenticacao();
        if(autenticacao.getCurrentUser() != null){
            startActivity(new Intent(this, Home.class));
        }else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
