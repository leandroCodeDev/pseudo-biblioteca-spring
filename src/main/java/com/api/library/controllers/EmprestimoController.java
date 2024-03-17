package com.api.library.controllers;

import com.api.library.dtos.EmprestimoRecord;
import com.api.library.models.EmprestimoModel;
import com.api.library.services.EmprestimoService;
import com.api.library.services.LibraryServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(LibraryServiceFacade libraryServiceFacade) {
        this.emprestimoService = libraryServiceFacade.emprestimoService();
        this.emprestimoService.setLivroService(libraryServiceFacade.livroService());
        this.emprestimoService.setMembroService(libraryServiceFacade.membroService());
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoRecord>> getAllEmprestimos() {
        List<EmprestimoRecord> emprestimos;
        emprestimos = emprestimoService.findAllEmprestimos();
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoRecord> getEmprestimo(@PathVariable Long id) {
        EmprestimoRecord emprestimo = emprestimoService.findEmprestimo(id);
        return new ResponseEntity<>(emprestimo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmprestimoRecord> saveEmprestimo(@RequestBody EmprestimoRecord emprestimo) {
        EmprestimoRecord savedEmprestimo;
        savedEmprestimo = emprestimoService.saveEmprestimo(emprestimo);
        return new ResponseEntity<>(savedEmprestimo, HttpStatus.CREATED);
    }
}
