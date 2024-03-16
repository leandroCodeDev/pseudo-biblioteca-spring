package com.api.library.controllers;


import com.api.library.dtos.MembroRecord;
import com.api.library.models.MembroModel;
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
    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @GetMapping
    public ResponseEntity<List<MembroModel>> getAllMembros() {
        List<MembroModel> membros;
        membros = membroService.findAllMembros();
        return new ResponseEntity<>(membros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MembroRecord> saveMembro(@RequestBody MembroRecord membro) {
        MembroRecord savedMembro = membroService.saveMembro(membro);
        return new ResponseEntity<>(savedMembro, HttpStatus.CREATED);
    }
}
