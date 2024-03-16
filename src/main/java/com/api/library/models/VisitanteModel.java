package com.api.library.models;

import com.api.library.dtos.VisitanteRecord;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "Visitante")
public class VisitanteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "text not null")
    private String nome;

    @Column(columnDefinition = "varchar(20)")
    private String telefone;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public VisitanteModel() {}
    public VisitanteModel(VisitanteRecord visitante) {
        this.id = visitante.id() != null ? visitante.id() : 0;
        this.nome = visitante.nome();
        this.telefone = visitante.telefone();
    }

    public VisitanteRecord toRecords() {
        return new VisitanteRecord(this.id, this.nome, this.telefone);
    }
}
