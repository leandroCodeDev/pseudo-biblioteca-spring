package com.api.library.services;

import com.api.library.dtos.EmprestimoRecord;
import com.api.library.models.EmprestimoModel;

import java.util.List;
import java.util.Optional;

public interface EmprestimoService {

    List<EmprestimoRecord> findAllEmprestimos();
    EmprestimoRecord findEmprestimo(Long id);
    List<EmprestimoModel> findEmprestimosByMembroId(Long idMembro);
    List<EmprestimoModel> findEmprestimosByLivroId(Long idLivro);

    void deleteAllEmprestimo(List<EmprestimoModel> emprestimos);
    EmprestimoRecord saveEmprestimo(EmprestimoRecord Emprestimo);

    EmprestimoModel saveEmprestimo(EmprestimoModel Emprestimo);

    void setMembroService(MembroService membroService);
    void setLivroService(LivroService livroService);

    Boolean deleteEmprestimo(Long id);
}
