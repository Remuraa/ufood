package com.uemura.ufood.services;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.domains.Entities.UsuarioEntity;
import com.uemura.ufood.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class UsuarioServiceTest {
    @InjectMocks
    UsuarioService service;

    @Mock
    UsuarioRepository repository;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginTest(){
        LoginDto loginDto = new LoginDto().setLogin("Renan").setSenha("123");
        UsuarioEntity usuarioEntity = new UsuarioEntity().setId(1L);

        when(repository.findByUsuarioAndSenha(loginDto.getLogin(), loginDto.getSenha())).thenReturn(Optional.of(usuarioEntity));

        Boolean result = service.login(loginDto);

        Assertions.assertTrue(result);
    }

    @Test
    public void loginFailTest(){
        LoginDto loginDto = new LoginDto().setLogin("Renan").setSenha("123");

        when(repository.findByUsuarioAndSenha(loginDto.getLogin(), loginDto.getSenha())).thenReturn(Optional.empty());

        Boolean result = service.login(loginDto);

        Assertions.assertFalse(result);
    }
}
