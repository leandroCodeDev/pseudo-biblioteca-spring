package com.api.library.services.impl;


import com.api.library.dtos.BibliotecarioRecord;
import com.api.library.dtos.LivroRecord;
import com.api.library.dtos.MembroRecord;
import com.api.library.exception.ModelRepositoryNotFoundException;
import com.api.library.models.EmprestimoModel;
import com.api.library.models.LivroModel;
import com.api.library.models.MembroModel;
import com.api.library.repositories.MembroRepository;
import com.api.library.services.BibliotecarioService;
import com.api.library.services.EmprestimoService;
import com.api.library.services.LibraryServiceFacade;
import com.api.library.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MembroServiceImpl implements MembroService {

    private final MembroRepository membroRepository;
    private EmprestimoService emprestimoService;

    @Autowired
    public MembroServiceImpl(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }



    public void setEmprestimoService(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @Override
    public List<MembroRecord> findAllMembros() {

        List<MembroModel> membroModels =  membroRepository.findAll();
        List<MembroRecord> membroRecords =  new ArrayList<>();
        for(MembroModel membroModel: membroModels){
            membroRecords.add(mapToMembroRecord(membroModel));
        }
        return membroRecords;
    }

    @Override
    public MembroRecord findMembro(Long id) {
        MembroModel membro = findMembroModel(id);
        return membro.toRecords();
    }

    public MembroModel findMembroModel(Long id) {
        return membroRepository.findById(id).orElseThrow(() -> new ModelRepositoryNotFoundException("Membro não encontrado"));
    }


    @Override
    public MembroRecord saveMembro(MembroRecord membro) {
        MembroModel membroModel = membroRepository.save(new MembroModel(membro));
        return membroModel.toRecords();
    }

    @Override
    public Boolean deleteMembro(Long id){
        List<EmprestimoModel> emprestimo = emprestimoService.findEmprestimosByMembroId(id);
        emprestimoService.deleteAllEmprestimo(emprestimo);
        membroRepository.deleteById(id);
        return  !membroRepository.existsById(id);
    }



    private MembroRecord mapToMembroRecord(MembroModel membro){
        return new MembroRecord(membro.getId(), membro.getNome(),membro.getTelefone(),membro.getEndereco());
    }


}
