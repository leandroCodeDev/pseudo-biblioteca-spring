package com.api.library.services.impl;

import com.api.library.dtos.EmprestimoRecord;
import com.api.library.exception.ModelRepositoryNotFoundException;
import com.api.library.models.EmprestimoModel;
import com.api.library.models.LivroModel;
import com.api.library.models.MembroModel;
import com.api.library.repositories.EmprestimoRepository;
import com.api.library.repositories.MembroRepository;
import com.api.library.services.EmprestimoService;
import com.api.library.services.LivroService;
import com.api.library.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final MembroService membroService;
    private final LivroService livroService;

    @Autowired
    public EmprestimoServiceImpl(EmprestimoRepository emprestimoRepository, MembroService membroService, LivroService livroService) {
        this.emprestimoRepository = emprestimoRepository;
        this.membroService = membroService;
        this.livroService = livroService;
    }

    @Override
    public List<EmprestimoModel> findAllEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Optional<EmprestimoModel> findEmprestimo(Long id) {
        return emprestimoRepository.findById(id);
    }

    @Override
    public EmprestimoRecord saveEmprestimo(EmprestimoRecord emprestimo) {

        membroService.findMembro(emprestimo.idMembro()).orElseThrow(() -> new ModelRepositoryNotFoundException("Membro não encontrado"));
        livroService.findLivro(emprestimo.idLivro()).orElseThrow(() -> new ModelRepositoryNotFoundException("Livro não encontrado"));


        EmprestimoModel emprestimoModel = emprestimoRepository.save(new EmprestimoModel(emprestimo));
        return emprestimoModel.toRecords();
    }

    @Override
    public EmprestimoModel saveEmprestimo(EmprestimoModel emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }
}
