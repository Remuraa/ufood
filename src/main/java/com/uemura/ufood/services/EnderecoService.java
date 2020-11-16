package com.uemura.ufood.services;

import com.uemura.ufood.domains.Entities.EnderecoEntity;
import com.uemura.ufood.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public EnderecoEntity salvar(EnderecoEntity endereco) {
        return repository.save(endereco);
    }
}
