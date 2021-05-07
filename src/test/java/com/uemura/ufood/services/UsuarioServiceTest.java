package com.uemura.ufood.services;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.domains.Entities.UsuarioEntity;
import com.uemura.ufood.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {
    @InjectMocks
    UsuarioService service;

    @Mock
    UsuarioRepository repository;

    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginTest(){
        LoginDto loginDto = new LoginDto().setLogin("Renan").setSenha("123");
        UsuarioEntity usuarioEntity = new UsuarioEntity().setId(1L);

        when(repository.findByUsuario(loginDto.getLogin())).thenReturn(Optional.of(usuarioEntity));
        when(bCryptPasswordEncoder.matches(loginDto.getSenha(), "123")).thenReturn(true);

        Boolean result = service.login(loginDto);

        Assertions.assertTrue(result);
    }

    @Test
    public void loginFailTest(){
        LoginDto loginDto = new LoginDto().setLogin("Renan").setSenha("123");

        when(repository.findByUsuario(loginDto.getLogin())).thenReturn(Optional.empty());

        Boolean result = service.login(loginDto);

        Assertions.assertFalse(result);
    }
}
