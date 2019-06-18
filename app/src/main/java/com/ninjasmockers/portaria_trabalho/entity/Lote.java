package com.ninjasmockers.portaria_trabalho.entity;

import com.google.firebase.database.DatabaseReference;
import com.ninjasmockers.portaria_trabalho.config.Configuracaofirebase;

public class Lote {
    private String id,lote;

    public Lote(String id, String lote) {
        this.id = id;
        this.lote = lote;
    }

    public void salvarnoFirebase(){
        DatabaseReference firebase = Configuracaofirebase.getFirebaseDatabase();
        firebase.child("lotes").child(this.id).setValue(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
