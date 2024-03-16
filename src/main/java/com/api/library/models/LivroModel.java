package com.api.library.models;

import com.api.library.dtos.LivroRecord;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Livro")
public class LivroModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(255) not null")
    private String nome;
    @Column(columnDefinition = "varchar(255) not null")
    private String autor;
    @Column(name = "ano_publicacao", columnDefinition = "varchar(255) not null")
    private Integer anoPublicacao;


    public LivroModel() {}

    public LivroModel(long id, String nome, String autor, Integer anoPublicacao) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public LivroModel(LivroRecord livro) {
        this.id = livro.id() != null ? livro.id() : 0;
        this.nome = livro.nome();
        this.autor = livro.autor();
        this.anoPublicacao = livro.anoPublicacao();
    }

    public LivroRecord toRecords(){
        return new LivroRecord(this.id, this.nome, this.autor, this.anoPublicacao);
    }

}
