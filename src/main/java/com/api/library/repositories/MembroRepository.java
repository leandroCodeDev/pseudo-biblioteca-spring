package com.api.library.repositories;


import com.api.library.models.MembroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<MembroModel, Long> {
}
