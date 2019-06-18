package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.ninjasmockers.portaria_trabalho.config.Configuracaofirebase;
import com.ninjasmockers.portaria_trabalho.config.Preferencias;
import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.entity.UsuarioLogin;
import com.ninjasmockers.portaria_trabalho.tasks.DownloadTask;
import com.ninjasmockers.portaria_trabalho.tasks.JokeTask;

public class MainActivity extends AppCompatActivity {
    private Preferencias preferencias;
    private TextView nome;
    private TextView jokeText;
    private ImageView imagem;

    private UsuarioLogin usuario;
    private TextView nomeDigitado;
    private TextView senhaDigitada;
    private Button botaoLogin;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // codigo vai sair
        preferencias = new Preferencias(getApplicationContext());
        nome = findViewById(R.id.textViewNome);
        imagem = findViewById(R.id.imageView);
        jokeText = findViewById(R.id.jokeText);
        String valor = preferencias.recuperaAnotacao();
        nome.setText(valor);
        String endereco = "https://www.petmd.com/sites/default/files/Acute-Dog-Diarrhea-47066074.jpg";
        chamarAsyncTask(endereco);
        chamarJokeTask();
        // novo código com firebase
        nomeDigitado = findViewById(R.id.editTextEmail);
        senhaDigitada = findViewById(R.id.editTextSenha);
        botaoLogin = findViewById(R.id.btEntrar);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNome = nomeDigitado.getText().toString();
                String textoSenha = senhaDigitada.getText().toString();

                if (!textoNome.isEmpty()) {
                    if (!textoSenha.isEmpty()) {
                        usuario = new UsuarioLogin();
                        usuario.setNome(textoNome);
                        usuario.setSenha(textoSenha);
                        validarLogin(textoNome, textoSenha);

                    } else {
                        Toast.makeText(MainActivity.this, "prencha a senha!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "prencha o email!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void chamarAsyncTask(String endereco) {
        DownloadTask download = new DownloadTask(MainActivity.this, imagem);
        download.execute(endereco);
    }

    private void chamarJokeTask() {
        JokeTask download = new JokeTask(MainActivity.this, jokeText);
        download.execute();
    }

    protected void cadastroLogin(View view) {

        startActivity(new Intent(this, CadastroLogin.class));
    }


    public void goHome() {
        //nomeDigitado = findViewById(R.id.editNomeId);
        // preferencias.salvarAnotacao(nomeDigitado.getText().toString());
        startActivity(new Intent(this, Home.class));
        finish();
    }

    public void validarLogin(String textoNome, String textoSenha) {
        autenticacao = Configuracaofirebase.getAutenticacao();
        autenticacao.signInWithEmailAndPassword(textoNome, textoSenha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    goHome();
                    //Toast.makeText(MainActivity.this, "Login realizado!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Erro ao fazer login!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }



}


