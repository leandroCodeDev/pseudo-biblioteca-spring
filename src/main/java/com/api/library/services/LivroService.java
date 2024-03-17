package com.api.library.services;


import com.api.library.dtos.LivroRecord;
import com.api.library.models.BibliotecarioModel;
import com.api.library.models.LivroModel;
import com.api.library.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public interface LivroService {

    List<LivroRecord> findAllLivros();

    LivroRecord findLivro(Long id);

    LivroModel findLivroModel(Long id);


    LivroRecord saveLivro(LivroRecord livro);

    Boolean deleteLivro(Long id);

    void setEmprestimoService(EmprestimoService emprestimoService);
}
