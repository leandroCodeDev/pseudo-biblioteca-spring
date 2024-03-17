package com.api.library.services.impl;

import com.api.library.services.*;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceFacadeImpl implements LibraryServiceFacade {
    private final BibliotecarioService bibliotecarioService;
    private final MembroService membroService;
    private final LivroService livroService;
    private final EmprestimoService emprestimoService;
    private final VisitanteService visitanteService;

    public LibraryServiceFacadeImpl(BibliotecarioService bibliotecarioService, MembroService membroService, LivroService livroService, EmprestimoService emprestimoService, VisitanteService visitanteService) {
        this.bibliotecarioService = bibliotecarioService;
        this.membroService = membroService;
        this.livroService = livroService;
        this.emprestimoService = emprestimoService;
        this.visitanteService = visitanteService;
    }

    public BibliotecarioService bibliotecarioService() {
        return bibliotecarioService;
    }

    public MembroService membroService() {
        return membroService;
    }

    public LivroService livroService() {
        return livroService;
    }

    public EmprestimoService emprestimoService() {
        return emprestimoService;
    }

    public VisitanteService visitanteService() {
        return visitanteService;
    }
}
