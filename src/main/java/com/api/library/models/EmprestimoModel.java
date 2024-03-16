package com.api.library.models;

import com.api.library.dtos.EmprestimoRecord;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Emprestimo")
public class EmprestimoModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_emprestimo", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dataEmprestimo;

    @Column(name = "data_devolucao", columnDefinition = "TIMESTAMP")
    private Date dataDevolucao;

    @ManyToOne(optional = false) // Indica que é uma chave estrangeira e não pode ser nula
    @JoinColumn(name = "idLivro", nullable = false) // Configura a coluna do banco de dados
    private LivroModel livro;

    @ManyToOne(optional = false) // Indica que é uma chave estrangeira e não pode ser nula
    @JoinColumn(name = "idMembro", nullable = false) // Configura a coluna do banco de dados
    private MembroModel membro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LivroModel getLivro() {
        return livro;
    }

    public void setLivro(LivroModel livro) {
        this.livro = livro;
    }

    public MembroModel getMembro() {
        return membro;
    }

    public void setMembro(MembroModel membro) {
        this.membro = membro;
    }

    @PrePersist
    public void prePersist() {
        // Define a data atual se a data de empréstimo for nula
        if (dataEmprestimo == null) {
            dataEmprestimo = new Date();
        }
    }

    public EmprestimoModel() {}

    public EmprestimoModel(long id) {
        this.id = id;
    }

    public EmprestimoModel(EmprestimoRecord emprestimo) {
        this.id = (emprestimo.id() != null) ? emprestimo.id() : 0;
        this.dataEmprestimo = emprestimo.dataEmprestimo();
        this.dataDevolucao = emprestimo.dataDevolucao();
        this.livro = new LivroModel(emprestimo.idLivro());
        this.membro = new MembroModel(emprestimo.idMembro());
    }


    public EmprestimoRecord toRecords(){
        return new EmprestimoRecord(this.id,this.dataEmprestimo,this.dataDevolucao,this.livro.getId(),this.membro.getId());
    }

}
