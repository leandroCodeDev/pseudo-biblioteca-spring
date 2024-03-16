package com.api.library.services.impl;


import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.LivroRecord;
import com.api.library.exception.ModelRepositoryNotFoundException;
import com.api.library.models.BibliotecarioModel;
import com.api.library.models.LivroModel;
import com.api.library.repositories.LivroRepository;
import com.api.library.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroRecord> findAllLivros() {
        List<LivroModel>  livros =  livroRepository.findAll();
        List<LivroRecord> livroRecords = new ArrayList<>();

        for (LivroModel livro: livros){
            livroRecords.add(mapToLivroRecord(livro));
        }
        return livroRecords;
    }

    @Override
    public LivroRecord findLivro(Long id) {
        LivroModel livro = livroRepository.findById(id).orElseThrow(() -> new ModelRepositoryNotFoundException("Livro não encontrado"));
        return livro.toRecords();
    }

    @Override
    public LivroModel findLivroModel(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new ModelRepositoryNotFoundException("Livro não encontrado"));
    }

    public LivroRecord saveLivro(LivroRecord livro) {
        LivroModel livroModel = livroRepository.save(new LivroModel(livro));
        return livroModel.toRecords();
    }

    private LivroRecord mapToLivroRecord(LivroModel livroModel) {

        return new LivroRecord(livroModel.getId(), livroModel.getNome(),livroModel.getAutor(),livroModel.getAnoPublicacao());
    }
}
