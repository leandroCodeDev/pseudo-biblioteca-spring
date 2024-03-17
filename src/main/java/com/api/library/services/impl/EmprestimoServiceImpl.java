package com.api.library.services.impl;

import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.EmprestimoRecord;
import com.api.library.exception.ModelRepositoryNotFoundException;
import com.api.library.models.BibliotecarioModel;
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

import java.util.ArrayList;
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
    public List<EmprestimoRecord> findAllEmprestimos() {
        List<EmprestimoModel> emprestimoModels = emprestimoRepository.findAll();
        List<EmprestimoRecord> emprestimoRecords = new ArrayList<>();
        for (EmprestimoModel emprestimo : emprestimoModels) {
            emprestimoRecords.add(mapToBibliotecarioRecord(emprestimo));
        }

        return emprestimoRecords;
    }

    public EmprestimoRecord findEmprestimo(Long id) {
        EmprestimoModel Emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new ModelRepositoryNotFoundException("Bibliotecário não encontrado"));
        return Emprestimo.toRecords();
    }

    @Override
    public EmprestimoRecord saveEmprestimo(EmprestimoRecord emprestimo) {

        MembroModel membro = membroService.findMembroModel(emprestimo.idMembro());
        LivroModel livro = livroService.findLivroModel(emprestimo.idLivro());

        EmprestimoModel emprestimoModel = emprestimoRepository.save(new EmprestimoModel(emprestimo,livro, membro));
        return emprestimoModel.toRecords();
    }

    @Override
    public EmprestimoModel saveEmprestimo(EmprestimoModel emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    private EmprestimoRecord mapToBibliotecarioRecord(EmprestimoModel emprestimo) {
        // Faça o mapeamento entre BibliotecarioModel e BibliotecarioRecord aqui
        // Por exemplo:
        return new EmprestimoRecord(emprestimo.getId(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao(), emprestimo.getLivro().getId(), emprestimo.getMembro().getId());
    }

}
