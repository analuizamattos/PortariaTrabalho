package com.ninjasmockers.portaria_trabalho.config;

import com.google.firebase.auth.FirebaseAuth;

public class Configuracaofirebase {
    private static FirebaseAuth autenticacao;

    public static FirebaseAuth getAutenticacao() {
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }


}
