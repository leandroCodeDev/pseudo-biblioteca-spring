package com.api.library.repositories;

import com.api.library.models.EmprestimoModel;
import com.api.library.models.VisitanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VisitanteRepository  extends JpaRepository<VisitanteModel, Long> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE visitante SET telefone = :telefone and nome = :nome WHERE id = :id", nativeQuery = true)
    void updateDadosById(Long id, String nome,String telefone);

    @Transactional
    @Modifying
    @Query(value = "UPDATE visitante SET nome = :nome WHERE id = :id", nativeQuery = true)
    void updateNomeById(Long id, String nome);
}
