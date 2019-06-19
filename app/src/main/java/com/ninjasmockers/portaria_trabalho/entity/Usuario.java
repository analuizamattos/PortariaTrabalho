package com.ninjasmockers.portaria_trabalho.entity;

public class Usuario {
    protected String nome,lote;
    protected String id;

    public Usuario(String nome, String lote, String id) {
        this.nome = nome;
        this.lote = lote;
        this.id = id;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}