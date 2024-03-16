package com.api.library.repositories;

import com.api.library.models.BibliotecarioModel;
import com.api.library.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecarioRepository extends JpaRepository<BibliotecarioModel, Long> {
}
