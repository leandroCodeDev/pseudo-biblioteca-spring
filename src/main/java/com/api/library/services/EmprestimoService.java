package com.api.library.services;

import com.api.library.dtos.EmprestimoRecord;
import com.api.library.models.EmprestimoModel;

import java.util.List;
import java.util.Optional;

public interface EmprestimoService {

    List<EmprestimoModel> findAllEmprestimos();
    Optional<EmprestimoModel> findEmprestimo(Long id);

    EmprestimoRecord saveEmprestimo(EmprestimoRecord Emprestimo);

    EmprestimoModel saveEmprestimo(EmprestimoModel Emprestimo);
}
