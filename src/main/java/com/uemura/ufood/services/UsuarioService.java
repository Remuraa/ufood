package com.uemura.ufood.services;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.domains.Dto.UsuarioDto;
import com.uemura.ufood.domains.Entities.UsuarioEntity;
import com.uemura.ufood.exceptions.ValidacaoException;
import com.uemura.ufood.repositories.UsuarioRepository;
import com.uemura.ufood.util.convertor.UsuarioConvertor;
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

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public Long salvar(UsuarioDto usuarioDto) {
        return salvar(UsuarioConvertor.converter(usuarioDto)).getId();
    }

    @Transactional
    public UsuarioEntity salvar(UsuarioEntity usuario) {
        cidadeService.salvar(usuario.getEndereco().getCidade());
        usuario.setSenha(bCryptPasswordEncoder().encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public boolean login(LoginDto loginDto) {
        UsuarioEntity usuario = repository.findByUsuario(loginDto.getLogin())
                .orElseThrow(() -> new  ValidacaoException("Login invalido"));
        return bCryptPasswordEncoder().matches(loginDto.getSenha(), usuario.getSenha());
    }

}
