package com.api.library.repositories;

import com.api.library.models.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository  extends JpaRepository<EmprestimoModel, Long> {
    List<EmprestimoModel> findByLivroId(Long idLivro);
    List<EmprestimoModel> findByMembroId(Long idMembro);
}
