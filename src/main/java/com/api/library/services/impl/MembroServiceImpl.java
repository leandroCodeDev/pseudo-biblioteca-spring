package com.api.library.services.impl;


import com.api.library.dtos.MembroRecord;
import com.api.library.models.LivroModel;
import com.api.library.models.MembroModel;
import com.api.library.repositories.MembroRepository;
import com.api.library.services.BibliotecarioService;
import com.api.library.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroServiceImpl implements MembroService {

    private final MembroRepository membroRepository;

    @Autowired
    public MembroServiceImpl(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    @Override
    public List<MembroModel> findAllMembros() {
        return membroRepository.findAll();
    }

    @Override
    public Optional<MembroModel> findMembro(Long id) {
        return membroRepository.findById(id);
    }

    @Override
    public MembroRecord saveMembro(MembroRecord membro) {
        MembroModel membroModel = membroRepository.save(new MembroModel(membro));
        return membroModel.toRecords();
    }
}
