package com.uemura.ufood.services;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.domains.Entities.UsuarioEntity;
import com.uemura.ufood.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        usuario.setSenha(bCryptPasswordEncoder().encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public boolean login(LoginDto loginDto) {
       return repository.findByUsuarioAndSenha(loginDto.getLogin(), loginDto.getSenha()).isPresent();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
