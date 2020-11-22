package com.uemura.ufood.services;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.domains.Dto.UsuarioDto;
import com.uemura.ufood.domains.Entities.UsuarioEntity;
import com.uemura.ufood.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UsuarioServiceTest {
    @Mock
    UsuarioService service;

    @Mock
    UsuarioRepository repository;

    @Test
    public void loginTest(){
        LoginDto loginDto = new LoginDto().setLogin("Renan").setSenha("123");
        UsuarioEntity usuarioEntity = new UsuarioEntity().setId(1L);

        Mockito.doReturn(usuarioEntity).when(repository.findByUsuarioAndSenha(loginDto.getLogin(), loginDto.getSenha()));

        UsuarioDto result = service.login(loginDto);

        Assertions.assertEquals(1L, result.getId());
    }

}
