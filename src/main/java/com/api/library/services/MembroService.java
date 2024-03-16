package com.api.library.services;


import com.api.library.dtos.MembroRecord;
import com.api.library.models.BibliotecarioModel;
import com.api.library.models.MembroModel;

import java.util.List;
import java.util.Optional;

public interface MembroService {
    List<MembroRecord> findAllMembros();

    MembroRecord findMembro(Long id);
    MembroModel findMembroModel(Long id);


    MembroRecord saveMembro(MembroRecord Membro);
}
