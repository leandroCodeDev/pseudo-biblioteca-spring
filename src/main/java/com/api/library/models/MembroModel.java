package com.api.library.models;

import com.api.library.dtos.MembroRecord;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Membro")
public class MembroModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "varchar(255) not null")
    private String nome;

    @Column(columnDefinition = "TEXT not null")
    private String endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public MembroModel() {}

    public MembroModel(long id) {
        this.id = id;
    }

    public MembroModel(MembroRecord membro) {
        this.id = membro.id() != null ? membro.id() : 0;
        this.nome = membro.nome();
        this.telefone = membro.telefone();
        this.endereco = membro.endereco();
    }

    public MembroRecord toRecords(){
        return new MembroRecord(this.id, this.nome, this.telefone, this.endereco);
    }
}
