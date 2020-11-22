package com.uemura.ufood.services;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.domains.Dto.UsuarioDto;
import com.uemura.ufood.domains.Entities.UsuarioEntity;
import com.uemura.ufood.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    CidadeService cidadeService;

    @Autowired
    EnderecoService enderecoService;

    @Transactional
    public UsuarioEntity salvar(UsuarioEntity usuario) {
        cidadeService.salvar(usuario.getEndereco().getCidade());
        enderecoService.salvar(usuario.getEndereco());
        return repository.save(usuario);
    }

    public UsuarioDto login(LoginDto loginDto) {
        return new UsuarioDto().setId(
                repository.findByUsuarioAndSenha(loginDto.getLogin(), loginDto.getSenha())
                        .orElseThrow(ValidationException::new).getId());
    }
}
