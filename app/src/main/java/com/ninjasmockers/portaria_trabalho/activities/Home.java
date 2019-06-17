package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.entity.Usuario;

public class Home extends AppCompatActivity {
private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
private DatabaseReference usuarios = referencia.child("usuarios");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*referencia.child("pontos").setValue("100");
        referencia.child("produtos").child("001").child("descricao").setValue("IfoneX");



*/
        Usuario usuario = new Usuario("Douglas","Angelo");

        referencia.child("usuarios").push().setValue(usuario);

    }
    protected void inserir(View view){
        startActivity(new Intent(this,CadastroVisitante.class));
    }
    protected void sair(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
