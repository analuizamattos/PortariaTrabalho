package com.ninjasmockers.portaria_trabalho.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ninjasmockers.portaria_trabalho.R;
import com.ninjasmockers.portaria_trabalho.config.Configuracaofirebase;
import com.ninjasmockers.portaria_trabalho.dao.helpers.Base64Custom;
import com.ninjasmockers.portaria_trabalho.dao.helpers.DBHelper;
import com.ninjasmockers.portaria_trabalho.entity.Lote;
import com.ninjasmockers.portaria_trabalho.entity.Morador;
import com.ninjasmockers.portaria_trabalho.entity.Usuario;
import com.ninjasmockers.portaria_trabalho.entity.UsuarioLogin;

public class CadastroLogin extends AppCompatActivity {
    private FirebaseAuth autenticacao;
    private EditText campoNome, campoEmail, campoSenha,campoLote,campoTelefone,campoCelular;
    private Button botaoCadastar;
    private UsuarioLogin usuario;
    private Morador morador;
    private Lote lote;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);
        campoNome = findViewById(R.id.editNomeId);
        campoEmail = findViewById(R.id.editEmailId);
        campoSenha = findViewById(R.id.editSenhaId);
        botaoCadastar = findViewById(R.id.btCriar);
        campoLote = findViewById(R.id.editNomeLote);
        campoTelefone = findViewById(R.id.editNomeTelefone );
        campoCelular = findViewById(R.id.editNomeCelular);


        botaoCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();
                String textoLote = campoLote.getText().toString();
                String textoTefone = campoTelefone.getText().toString();
                String textoCelular = campoCelular.getText().toString();

                if (validarCampos(textoEmail) == true & validarCampos(textoSenha) == true & validarCampos(textoNome) == true  & validarCampos(textoLote) == true
                        & validarCampos(textoTefone) == true  & validarCampos(textoCelular) == true ) {
                    morador = new Morador(textoNome,textoLote, Base64Custom.codificarBase64(textoEmail),textoEmail, textoCelular, textoTefone);
                    lote = new Lote(Base64Custom.codificarBase64(textoEmail), textoLote);
                    usuario = new UsuarioLogin();
                    usuario.setNome(textoNome);
                    usuario.setEmail(textoEmail);
                    usuario.setSenha(textoSenha);
                    cadastrarUsuario();
                   // morador.salvarnoFirebase();
                   // lote.salvarnoFirebase();
                }

            }
        });
    }

    protected void irMain() {
        //autenticacao.createUserWithEmailAndPassword("douglasdcangelo@gmail.com", "goufe2");
        startActivity(new Intent(this, Telainicial.class));
        //autenticacao.signOut();
    }

    public boolean validarCampos(String valida) {
        if (!valida.isEmpty()) {
            return true;
        } else {
            Toast.makeText(CadastroLogin.this, "Prencha todos os campos", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void cadastrarUsuario() {

        autenticacao = Configuracaofirebase.getAutenticacao();
        autenticacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    irMain(); //Toast.makeText(CadastroLogin.this, "Sucesso ao cadastrar usuario!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CadastroLogin.this,
                            "Erro ao cadastrar usuario!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
/* } else if (validarCampos(textoNome) == true) {

                } else if (validarCampos(textoNome) == true) {

                }
*/
/*
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
*/
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