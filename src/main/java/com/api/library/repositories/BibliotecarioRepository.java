package com.api.library.repositories;

import com.api.library.models.BibliotecarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioModel, Long> {

    @Transactional
    @Modifying
    @Query( value = "UPDATE Bibliotecario  SET senha = :senha WHERE id = :id", nativeQuery = true)
    BibliotecarioModel updateSenhaById(Long id, String senha);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Bibliotecario SET nome = :nome WHERE id = :id", nativeQuery = true)
    BibliotecarioModel updateNomeById(Long id, String nome);

}
