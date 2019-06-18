package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.config.Configuracaofirebase;
import com.ninjasmockers.portaria_trabalho.dao.helpers.DBHelper;
import com.ninjasmockers.portaria_trabalho.entity.Usuario;
import com.ninjasmockers.portaria_trabalho.entity.UsuarioLogin;

public class CadastroLogin extends AppCompatActivity {
    private FirebaseAuth autenticacao ;
    private EditText campoNome, campoEmail, campoSenha;
    private Button botaoCadastar;
    private UsuarioLogin usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);
        campoNome = findViewById(R.id.editNomeId);
        campoEmail = findViewById(R.id.editEmailId);
        campoSenha = findViewById(R.id.editSenhaId);
        botaoCadastar = findViewById(R.id.btCriar);


        botaoCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();


                // validar se os campos foram preenchidos
                if (!textoNome.isEmpty()) {
                    if (!textoEmail.isEmpty()) {
                        if (!textoSenha.isEmpty()) {
                            usuario = new UsuarioLogin();
                            usuario.setNome(textoNome);
                            usuario.setEmail(textoEmail);
                            usuario.setSenha(textoSenha);
                            cadastrarUsuario();
                        } else {
                            Toast.makeText(CadastroLogin.this, "prencha a senha!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(CadastroLogin.this, "prencha o email!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CadastroLogin.this, "prencha o nome!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

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




    protected void btCriar(View view) {
        //autenticacao.createUserWithEmailAndPassword("douglasdcangelo@gmail.com", "goufe2");
        startActivity(new Intent(this, MainActivity.class));
    }

    protected void cancelar(View view) {
        autenticacao.signOut();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void cadastrarUsuario() {
        autenticacao = Configuracaofirebase.getAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CadastroLogin.this, "Sucesso ao cadastrar usuario!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CadastroLogin.this, "Erro ao cadastrar usuario!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}


