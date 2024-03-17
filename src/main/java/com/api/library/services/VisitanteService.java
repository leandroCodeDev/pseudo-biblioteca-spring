package com.api.library.services;


import com.api.library.dtos.VisitanteRecord;
import com.api.library.models.BibliotecarioModel;
import com.api.library.models.VisitanteModel;

import java.util.List;
import java.util.Optional;

public interface VisitanteService {

    List<VisitanteRecord> findAllVisitantes();

    VisitanteRecord findVisitante(Long id);


    VisitanteRecord saveVisitante(VisitanteRecord Visitante);
    Boolean deleteVisitante(Long id);

    void updateVisitante(Long id, String nome);
}
