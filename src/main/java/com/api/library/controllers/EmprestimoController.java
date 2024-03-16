package com.api.library.controllers;

import com.api.library.dtos.EmprestimoRecord;
import com.api.library.models.EmprestimoModel;
import com.api.library.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {


    private EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
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
