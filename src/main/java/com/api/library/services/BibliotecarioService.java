package com.api.library.services;


import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.models.BibliotecarioModel;
import com.api.library.models.EmprestimoModel;
import com.api.library.models.LivroModel;
import com.api.library.repositories.BibliotecarioRepository;
import com.api.library.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


public interface BibliotecarioService {
    List<BibliotecarioModel> findAllBibliotecarios();

    Optional<BibliotecarioModel> findBibliotecario(Long id);
    BibliotecarioRecord saveBibliotecario(BibliotecarioRecord Bibliotecario);

    String realizarEmprestimo(Long idBibliotecario, Long idMembro, Long idLivro);
}
