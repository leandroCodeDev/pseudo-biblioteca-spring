package com.api.library.controllers;


import com.api.library.dtos.LivroRecord;
import com.api.library.models.LivroModel;
import com.api.library.services.LibraryServiceFacade;
import com.api.library.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LibraryServiceFacade libraryServiceFacade) {
        this.livroService = libraryServiceFacade.livroService();
        this.livroService.setEmprestimoService(libraryServiceFacade.emprestimoService());
    }

    @GetMapping
    public ResponseEntity<List<LivroRecord>> getAllLivros() {
        List<LivroRecord> livros;
        livros = livroService.findAllLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroRecord> getLivro( @PathVariable("id") Long id) {
        LivroRecord livro;
        livro = livroService.findLivro(id);
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteLivro( @PathVariable("id") Long id) {
        return new ResponseEntity<>(livroService.deleteLivro(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LivroRecord> saveLivro(@RequestBody LivroRecord livro) {
        LivroRecord savedLivro = livroService.saveLivro(livro);
        return new ResponseEntity<>(savedLivro, HttpStatus.CREATED);
    }
}
