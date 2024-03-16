package com.api.library.services.impl;


import com.api.library.dtos.VisitanteRecord;
import com.api.library.exception.ModelRepositoryNotFoundException;
import com.api.library.models.VisitanteModel;
import com.api.library.repositories.VisitanteRepository;
import com.api.library.services.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<VisitanteRecord> findAllVisitantes() {
        List<VisitanteModel> visitanteModels = visitanteRepository.findAll();
        List<VisitanteRecord> visitanteRecords = new ArrayList<>();

        for (VisitanteModel visitanteModel : visitanteModels){
            visitanteRecords.add(mapVisitanteToRecord(visitanteModel));
        }

        return visitanteRecords;
    }



    @Override
    public VisitanteRecord findVisitante(Long id) {
        VisitanteModel visitante = visitanteRepository.findById(id).orElseThrow(() -> new ModelRepositoryNotFoundException("Visitante não encontrado"));
        return visitante.toRecords();
    }

    @Override
    public VisitanteRecord saveVisitante(VisitanteRecord visitante) {
        VisitanteModel visitanteModel = visitanteRepository.save(new VisitanteModel(visitante));
        return visitanteModel.toRecords();
    }

    private VisitanteRecord mapVisitanteToRecord(VisitanteModel visitanteModel) {
        return  new VisitanteRecord(visitanteModel.getId(), visitanteModel.getNome(), visitanteModel.getTelefone());
    }
}
