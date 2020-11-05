package com.uemura.ufood.services;

import com.uemura.ufood.domains.CidadeEntity;
import com.uemura.ufood.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    public CidadeEntity salvar(CidadeEntity cidade) {
        return repository.save(cidade);
    }
}
