package com.api.library.controllers;


import com.api.library.dtos.MembroRecord;
import com.api.library.models.MembroModel;
import com.api.library.services.LibraryServiceFacade;
import com.api.library.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membro")
public class MembroController {

    private MembroService membroService;

    @Autowired
    public MembroController(LibraryServiceFacade libraryServiceFacade) {
        this.membroService = libraryServiceFacade.membroService();
        this.membroService.setEmprestimoService(libraryServiceFacade.emprestimoService());
    }

    @GetMapping
    public ResponseEntity<List<MembroRecord>> getAllMembros() {
        List<MembroRecord> membros;
        membros = membroService.findAllMembros();
        return new ResponseEntity<>(membros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembroRecord> getMembro(@PathVariable Long id) {
        MembroRecord membros;
        membros = membroService.findMembro(id);
        return new ResponseEntity<>(membros, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMembros(@PathVariable Long id) {
        return new ResponseEntity<>(membroService.deleteMembro(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MembroRecord> saveMembro(@RequestBody MembroRecord membro) {
        MembroRecord savedMembro = membroService.saveMembro(membro);
        return new ResponseEntity<>(savedMembro, HttpStatus.CREATED);
    }
}
