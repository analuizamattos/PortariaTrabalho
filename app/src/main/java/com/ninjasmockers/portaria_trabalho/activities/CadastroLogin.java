package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.dao.helpers.DBHelper;
import com.ninjasmockers.portaria_trabalho.entity.Usuario;

public class CadastroLogin extends AppCompatActivity {
    private FirebaseAuth autenticacao = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);
/*
        DBHelper banco = new DBHelper(this, null,  null, 1, null);
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("joaozinho");
        usuario.setSobrenome("sobrenome né :D");

        boolean saved = banco.save(usuario);
        Log.i("saved", String.valueOf(saved));

        String result = banco.getAllUsers();
        Log.i("result", result);
*/
      /* autenticacao.createUserWithEmailAndPassword("douglasdcangelo@gmail.com", "goufe2")  // cria usuario
               .addOnCompleteListener(CadastroLogin.this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Log.i("CreateUser", "Sucesso ao cadastrar usuario");
                       }else{
                           Log.i("CreateUser", "Erro ao cadastrar usuario");
                       }

                   }
               });

    }
    */
        autenticacao.signInWithEmailAndPassword ("douglasdcangelo@gmail.com", "goufe2")  // loga usuario
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("signIn", "Sucesso ao Logar");
                        }else{
                            Log.i("signIn", "Erro ao logar");
                        }

                    }
                });

    }

     // autenticacao.signOut();
    protected void criar(View view){
        //autenticacao.createUserWithEmailAndPassword("douglasdcangelo@gmail.com", "goufe2");
        startActivity(new Intent(this,MainActivity.class));
    }

    protected void cancelar(View view){
        autenticacao.signOut();
        startActivity(new Intent(this,MainActivity.class));
    }
}
