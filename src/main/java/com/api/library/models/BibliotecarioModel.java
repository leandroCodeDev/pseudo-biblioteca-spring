package com.api.library.models;

import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.LivroRecord;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Bibliotecario")
public class BibliotecarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "varchar(255) not null")
    private String nome;
    @Column(columnDefinition = "varchar(255) not null")
    private String email;
    @Column(columnDefinition = "varchar(255) not null")
    private String senha;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BibliotecarioModel(){};
    public BibliotecarioModel(BibliotecarioRecord bibliotecario) {
        this.id = bibliotecario.id() != null ? bibliotecario.id() : 0;
        this.nome = bibliotecario.nome();
        this.email = bibliotecario.email();
        this.senha = bibliotecario.senha();
    }

    public BibliotecarioRecord toRecords(){
        return new BibliotecarioRecord(this.id, this.nome, this.email,null);
    }
}
