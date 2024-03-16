package com.api.library.controllers;


import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.EmprestimoRequest;
import com.api.library.models.BibliotecarioModel;
import com.api.library.models.EmprestimoModel;
import com.api.library.services.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {

    private BibliotecarioService bibliotecarioService;

    @Autowired
    public BibliotecarioController(BibliotecarioService bibliotecarioService) {
        this.bibliotecarioService = bibliotecarioService;
    }

    @GetMapping
    public ResponseEntity<List<BibliotecarioModel>> getAllBibliotecarios() {
        List<BibliotecarioModel> bibliotecarios;
        bibliotecarios = bibliotecarioService.findAllBibliotecarios();
        return new ResponseEntity<>(bibliotecarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BibliotecarioRecord> saveBibliotecario(@RequestBody BibliotecarioRecord bibliotecario) {
        BibliotecarioRecord savedBibliotecario;
        savedBibliotecario = bibliotecarioService.saveBibliotecario(bibliotecario);
        return new ResponseEntity<>(savedBibliotecario, HttpStatus.CREATED);
    }


    @PostMapping("/{id}/emprestimo")
    public ResponseEntity<String> realizarEmprestimo(
            @PathVariable("id") Long idBibliotecario,
            @RequestBody EmprestimoRequest emprestimoRequest) {
        // Aqui você pode validar se o bibliotecário existe e tem permissão para realizar o empréstimo
        // e também se o membro e o livro existem no sistema.

        // Por simplicidade, suponha que emprestimoService.realizarEmprestimo
        // é um método que realiza o empréstimo e retorna uma mensagem de sucesso.
        String mensagem = bibliotecarioService.realizarEmprestimo(idBibliotecario, emprestimoRequest.getIdMembro(), emprestimoRequest.getIdLivro());

        return new ResponseEntity<>(mensagem, HttpStatus.OK);

    }
}
