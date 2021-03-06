package com.ninjasmockers.portaria_trabalho.entity;

import com.google.firebase.database.DatabaseReference;
import com.ninjasmockers.portaria_trabalho.config.Configuracaofirebase;

public class Morador extends Usuario {

    private String email,celular,telefone;
    private boolean ativo = false;

    public void salvarnoFirebase(){
        DatabaseReference firebase = Configuracaofirebase.getFirebaseDatabase();
        firebase.child("usuarios").child(this.id).setValue(this);
    }

    public Morador(String nome, String lote, String id, String email, String celular, String telefone) {
        super(nome, lote, id);
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


}
