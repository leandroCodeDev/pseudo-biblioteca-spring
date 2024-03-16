package com.api.library.services.impl;


import com.api.library.dtos.LivroRecord;
import com.api.library.exception.ModelRepositoryNotFoundException;
import com.api.library.models.LivroModel;
import com.api.library.repositories.LivroRepository;
import com.api.library.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroModel> findAllLivros() {
        return livroRepository.findAll();
    }

    @Override
    public Optional<LivroModel> findLivro(Long id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        if (livro.isEmpty()) {
            throw new ModelRepositoryNotFoundException("Livro não encontrado");
        }
        return livro;
    }

    public LivroRecord saveLivro(LivroRecord livro) {
        LivroModel livroModel = livroRepository.save(new LivroModel(livro));
        return livroModel.toRecords();
    }
}
