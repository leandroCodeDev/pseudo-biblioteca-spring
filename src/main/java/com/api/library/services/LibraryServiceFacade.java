package com.api.library.services;

import org.springframework.stereotype.Service;

@Service
public interface LibraryServiceFacade {
    BibliotecarioService bibliotecarioService();
    MembroService membroService();
    LivroService livroService();
    EmprestimoService emprestimoService();
}
