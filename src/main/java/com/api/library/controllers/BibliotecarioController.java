package com.api.library.controllers;


import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.EmprestimoBibliotecarioRecord;
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


    @GetMapping("/{id}")
    public BibliotecarioRecord getBibliotecario( @PathVariable("id") Long id) {
        BibliotecarioRecord bibliotecarios = bibliotecarioService.findBibliotecario(id);
        return new ResponseEntity<>(bibliotecarios, HttpStatus.OK).getBody();
    }


    @GetMapping
    public ResponseEntity<List<BibliotecarioRecord>> getAllBibliotecarios() {
        List<BibliotecarioRecord> bibliotecarios;
        bibliotecarios = bibliotecarioService.findAllBibliotecarios();
        return new ResponseEntity<>(bibliotecarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BibliotecarioRecord> saveBibliotecario(@RequestBody BibliotecarioRecord bibliotecario) {
        BibliotecarioRecord savedBibliotecario;
        savedBibliotecario = bibliotecarioService.saveBibliotecario(bibliotecario);
        return new ResponseEntity<>(savedBibliotecario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBibliotecario(@PathVariable Long id) {
        return new ResponseEntity<>(bibliotecarioService.deleteBibliotecario(id), HttpStatus.CREATED);
    }



    @PostMapping("/{id}/emprestimo")
    public ResponseEntity<String> realizarEmprestimo(
            @PathVariable("id") Long idBibliotecario,
            @RequestBody EmprestimoBibliotecarioRecord emprestimoBibliotecarioRecord) {
        // Aqui você pode validar se o bibliotecário existe e tem permissão para realizar o empréstimo
        // e também se o membro e o livro existem no sistema.

        // Por simplicidade, suponha que emprestimoService.realizarEmprestimo
        // é um método que realiza o empréstimo e retorna uma mensagem de sucesso.
        String mensagem = bibliotecarioService.realizarEmprestimo(idBibliotecario, emprestimoBibliotecarioRecord);

        return new ResponseEntity<>(mensagem, HttpStatus.OK);

    }
}
