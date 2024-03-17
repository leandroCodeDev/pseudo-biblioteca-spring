package com.api.library.services.impl;


import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.EmprestimoBibliotecarioRecord;
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

import java.util.ArrayList;
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
    public List<BibliotecarioRecord> findAllBibliotecarios() {
        List<BibliotecarioModel> bibliotecarios = bibliotecarioRepository.findAll();
        List<BibliotecarioRecord> bibliotecarioRecords = new ArrayList<>();

        for (BibliotecarioModel bibliotecarioModel : bibliotecarios) {
            bibliotecarioRecords.add(mapToBibliotecarioRecord(bibliotecarioModel));
        }

        return bibliotecarioRecords;

    }

    @Override
    public BibliotecarioRecord findBibliotecario(Long id) {
        BibliotecarioModel bibliotecarioModel = findBibliotecarioModel(id);
        return bibliotecarioModel.toRecords();
    }

    @Override
    public BibliotecarioModel findBibliotecarioModel(Long id) {
        return  bibliotecarioRepository.findById(id).orElseThrow(() -> new ModelRepositoryNotFoundException("Bibliotecário não encontrado"));

    }

    @Override
    public BibliotecarioRecord saveBibliotecario(BibliotecarioRecord bibliotecario) {
        BibliotecarioModel bibliotecarioModel = bibliotecarioRepository.save(new BibliotecarioModel(bibliotecario));
        return bibliotecarioModel.toRecords();
    }

    public String realizarEmprestimo( Long idBibliotecario, EmprestimoBibliotecarioRecord emprestimoBibliotecarioRecord) {
        Long idLivro = emprestimoBibliotecarioRecord.idLivro();
        Long idMembro = emprestimoBibliotecarioRecord.idMembro();
        // Lógica para realizar o empréstimo
        BibliotecarioModel bibliotecario = bibliotecarioRepository.findById(idBibliotecario)
                .orElseThrow(() -> new ModelRepositoryNotFoundException("Bibliotecário não encontrado"));



        // Verificar se o membro com o ID fornecido existe
        MembroModel membro = membroService.findMembroModel(idMembro);

        // Verificar se o livro com o ID fornecido existe
        LivroModel livro = livroService.findLivroModel(idLivro);

        // Realizar o empréstimo do livro para o membro
        EmprestimoModel emprestimo = new EmprestimoModel();
        emprestimo.setMembro(membro);
        emprestimo.setLivro(livro);
        emprestimoService.saveEmprestimo(emprestimo);

        return "Empréstimo realizado com sucesso";
    }

    public Boolean deleteBibliotecario(Long id){
        bibliotecarioRepository.deleteById(id);
        return !bibliotecarioRepository.existsById(id);
    }


    private BibliotecarioRecord mapToBibliotecarioRecord(BibliotecarioModel bibliotecarioModel) {
        // Faça o mapeamento entre BibliotecarioModel e BibliotecarioRecord aqui
        // Por exemplo:
        return new BibliotecarioRecord(bibliotecarioModel.getId(), bibliotecarioModel.getNome(),bibliotecarioModel.getEmail(),null);
    }
}
