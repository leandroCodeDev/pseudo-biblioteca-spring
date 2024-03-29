package com.api.library.controllers;


import com.api.library.dtos.VisitanteRecord;
import com.api.library.models.VisitanteModel;
import com.api.library.services.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {


    private VisitanteService visitanteService;

    @Autowired
    public VisitanteController(VisitanteService visitanteService) {
        this.visitanteService = visitanteService;
    }

    @GetMapping
    public ResponseEntity<List<VisitanteRecord>> getAllVisitantes() {
        List<VisitanteRecord> visitantes;
        visitantes = visitanteService.findAllVisitantes();
        return new ResponseEntity<>(visitantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitanteRecord> getVisitante(@PathVariable Long id) {
        VisitanteRecord visitante;
        visitante = visitanteService.findVisitante(id);
        return new ResponseEntity<>(visitante, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteVisitante(@PathVariable Long id) {
        return new ResponseEntity<>(visitanteService.deleteVisitante(id), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVisitante(@PathVariable Long id,
                                                @RequestParam(name = "nome", required = false) String nome
    ) {
        visitanteService.updateVisitante(id,nome);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<VisitanteRecord> saveVisitante(@RequestBody VisitanteRecord visitante) {
        VisitanteRecord savedVisitante;
        savedVisitante = visitanteService.saveVisitante(visitante);
        return new ResponseEntity<>(savedVisitante, HttpStatus.CREATED);
    }
}
