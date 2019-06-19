package com.ninjasmockers.portaria_trabalho.entity;

import java.time.Instant;
import java.util.Date;

public class Autorizacao {
    private Date datafinal,datainicial;
    private String observacao, lote, idMorador,idVisitante,id;



    public Autorizacao(String observacao, String lote, String idMorador, String idVisitante) {
        this.observacao = observacao;
        this.lote = lote;
        this.idMorador = idMorador;
        this.idVisitante = idVisitante;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public Date getDatainicial() {
        return datainicial;
    }

    public void setDatainicial(Date datainicial) {
        this.datainicial = datainicial;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(String idMorador) {
        this.idMorador = idMorador;
    }

    public String getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(String idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
