package com.api.library.services.impl;


import com.api.library.dtos.VisitanteRecord;
import com.api.library.models.VisitanteModel;
import com.api.library.repositories.VisitanteRepository;
import com.api.library.services.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitanteServiceImpl implements VisitanteService {

    private final VisitanteRepository visitanteRepository;

    @Autowired
    public VisitanteServiceImpl(VisitanteRepository visitanteRepository) {
        this.visitanteRepository = visitanteRepository;
    }

    @Override
    public List<VisitanteModel> findAllVisitantes() {
        return visitanteRepository.findAll();
    }

    @Override
    public Optional<VisitanteModel> findVisitante(Long id) {
        return visitanteRepository.findById(id);
    }

    @Override
    public VisitanteRecord saveVisitante(VisitanteRecord visitante) {
        VisitanteModel visitanteModel = visitanteRepository.save(new VisitanteModel(visitante));
        return visitanteModel.toRecords();
    }
}
