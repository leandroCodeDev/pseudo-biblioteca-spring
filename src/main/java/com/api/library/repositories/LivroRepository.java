package com.api.library.repositories;

import com.api.library.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Livro SET nome = :nome WHERE id = :id", nativeQuery = true)
    void updateNomeById(Long id, String nome);


}
