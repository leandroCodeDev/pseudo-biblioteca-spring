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
    public ResponseEntity<List<VisitanteModel>> getAllVisitantes() {
        List<VisitanteModel> visitantes;
        visitantes = visitanteService.findAllVisitantes();
        return new ResponseEntity<>(visitantes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VisitanteRecord> saveVisitante(@RequestBody VisitanteRecord visitante) {
        VisitanteRecord savedVisitante;
        savedVisitante = visitanteService.saveVisitante(visitante);
        return new ResponseEntity<>(savedVisitante, HttpStatus.CREATED);
    }
}
