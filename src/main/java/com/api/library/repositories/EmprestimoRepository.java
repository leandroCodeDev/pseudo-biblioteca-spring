package com.api.library.repositories;

import com.api.library.models.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface EmprestimoRepository  extends JpaRepository<EmprestimoModel, Long> {
    List<EmprestimoModel> findByLivroId(Long idLivro);
    List<EmprestimoModel> findByMembroId(Long idMembro);

    @Transactional
    @Modifying
    @Query(value ="UPDATE Emprestimo SET data_emprestimo = :dataEmprestimo WHERE id = :id", nativeQuery = true)
    void updateDataEmprestimoById(Long id, Date dataEmprestimo);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Emprestimo SET data_devolucao = :dataDevolucao WHERE id = :id", nativeQuery = true)
    void updateDataDevolucaoById(Long id, Date dataDevolucao);

}
