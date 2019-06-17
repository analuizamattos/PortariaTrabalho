package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.ninjasmockers.portaria_trabalho.config.Preferencias;
import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.tasks.DownloadTask;
import com.ninjasmockers.portaria_trabalho.tasks.JokeTask;

public class MainActivity extends AppCompatActivity {
    private Preferencias preferencias;
    private TextView nome;
    private TextView jokeText;
    private TextInputEditText nomeDigitado;
    private ImageView imagem;
    //private FirebaseAuth autenticacao = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias = new Preferencias(getApplicationContext());
        nome = findViewById(R.id.textViewNome);
        imagem = findViewById(R.id.imageView);
        jokeText = findViewById(R.id.jokeText);

        String valor = preferencias.recuperaAnotacao();
        nome.setText(valor);

        String endereco = "https://www.petmd.com/sites/default/files/Acute-Dog-Diarrhea-47066074.jpg";
        chamarAsyncTask(endereco);
        chamarJokeTask();
    }

    private void chamarAsyncTask(String endereco){
        DownloadTask download = new DownloadTask(MainActivity.this, imagem);
        download.execute(endereco);
    }

    private void chamarJokeTask(){
        JokeTask download = new JokeTask(MainActivity.this, jokeText);
        download.execute();
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


