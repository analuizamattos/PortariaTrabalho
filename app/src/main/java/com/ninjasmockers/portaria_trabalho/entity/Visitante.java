package com.ninjasmockers.portaria_trabalho.entity;

public class Visitante extends Usuario{
private String placaCarro,modeloCarro,rg;

    public Visitante(String nome, String lote, String id, String placaCarro, String modeloCarro, String rg) {
        super(nome, lote, id);
        this.placaCarro = placaCarro;
        this.modeloCarro = modeloCarro;
        this.rg = rg;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
