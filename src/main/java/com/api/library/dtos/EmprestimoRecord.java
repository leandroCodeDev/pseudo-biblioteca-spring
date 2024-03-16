package com.api.library.dtos;

import java.util.Date;

public record EmprestimoRecord(Long id, Date dataEmprestimo,Date dataDevolucao, Long idLivro, Long idMembro) {
}
