package com.api.library.services.impl;


import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.LivroRecord;
import com.api.library.exception.ModelRepositoryNotFoundException;
import com.api.library.models.BibliotecarioModel;
import com.api.library.models.EmprestimoModel;
import com.api.library.models.LivroModel;
import com.api.library.models.MembroModel;
import com.api.library.repositories.BibliotecarioRepository;
import com.api.library.services.BibliotecarioService;
import com.api.library.services.EmprestimoService;
import com.api.library.services.LivroService;
import com.api.library.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecarioServiceImpl implements BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;
    private final MembroService membroService;
    private final LivroService livroService;
    private final EmprestimoService emprestimoService;

    @Autowired
    public BibliotecarioServiceImpl(BibliotecarioRepository bibliotecarioRepository, MembroService membroService, LivroService livroService, EmprestimoService emprestimoService) {
        this.bibliotecarioRepository = bibliotecarioRepository;
        this.membroService = membroService;
        this.livroService = livroService;
        this.emprestimoService = emprestimoService;
    }

    @Override
    public List<BibliotecarioModel> findAllBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    @Override
    public Optional<BibliotecarioModel> findBibliotecario(Long id) {
        return bibliotecarioRepository.findById(id);
    }

    @Override
    public BibliotecarioRecord saveBibliotecario(BibliotecarioRecord bibliotecario) {
        BibliotecarioModel bibliotecarioModel = bibliotecarioRepository.save(new BibliotecarioModel(bibliotecario));
        return bibliotecarioModel.toRecords();
    }

    public String realizarEmprestimo(Long idBibliotecario, Long idMembro, Long idLivro) {
        // Lógica para realizar o empréstimo
        BibliotecarioModel bibliotecario = bibliotecarioRepository.findById(idBibliotecario)
                .orElseThrow(() -> new ModelRepositoryNotFoundException("Bibliotecário não encontrado"));



        // Verificar se o membro com o ID fornecido existe
        Optional<MembroModel> membro = membroService.findMembro(idMembro);
        if (membro.isEmpty()) {
            throw new ModelRepositoryNotFoundException("Membro não encontrado");
        }

        // Verificar se o livro com o ID fornecido existe
        Optional<LivroModel> livro = livroService.findLivro(idLivro);
        if (livro.isEmpty()) {
            throw new ModelRepositoryNotFoundException("Livro não encontrado");
        }

        // Realizar o empréstimo do livro para o membro
        EmprestimoModel emprestimo = new EmprestimoModel();
        emprestimo.setMembro(membro.get());
        emprestimo.setLivro(livro.get());
        emprestimoService.saveEmprestimo(emprestimo);

        return "Empréstimo realizado com sucesso";
    }
}
