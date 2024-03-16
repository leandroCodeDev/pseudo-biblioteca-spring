package com.api.library.repositories;

import com.api.library.models.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository  extends JpaRepository<EmprestimoModel, Long> {
}
