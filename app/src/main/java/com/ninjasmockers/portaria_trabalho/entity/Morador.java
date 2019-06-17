package com.ninjasmockers.portaria_trabalho.entity;

public class Morador extends Usuario {

    private String email,celular,telefone;
    private boolean ativo = false;

    public Morador(String nome, String sobrenome, String email) {
        super(nome, sobrenome);
        this.email = email;
    }
}
