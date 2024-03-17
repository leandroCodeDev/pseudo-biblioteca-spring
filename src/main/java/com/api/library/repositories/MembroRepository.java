package com.api.library.repositories;


import com.api.library.models.MembroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MembroRepository extends JpaRepository<MembroModel, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE membro SET telefone = :telefone WHERE id = :id", nativeQuery = true)
    void updateTelefoneById(Long id, String telefone);


}
