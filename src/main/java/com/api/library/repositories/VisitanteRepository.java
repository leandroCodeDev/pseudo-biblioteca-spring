package com.api.library.repositories;

import com.api.library.models.EmprestimoModel;
import com.api.library.models.VisitanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitanteRepository  extends JpaRepository<VisitanteModel, Long> {
}
