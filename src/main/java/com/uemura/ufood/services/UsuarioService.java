package com.uemura.ufood.services;

import com.uemura.ufood.domains.CidadeEntity;
import com.uemura.ufood.domains.EnderecoEntity;
import com.uemura.ufood.domains.UsuarioEntity;
import com.uemura.ufood.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public void testeSalvar() {
        salvar(new UsuarioEntity()
                .setNome("Renan")
                .setUsuario("Renan")
                .setSobrenome("Uemura")
                .setEndereco(
                        new EnderecoEntity()
                                .setNumero("111")
                                .setCidade(
                                        new CidadeEntity()
                                                .setNome("Conchal"))));
    }

    @Transactional
    public UsuarioEntity salvar(UsuarioEntity usuario) {
        cidadeService.salvar(usuario.getEndereco().getCidade());
        enderecoService.salvar(usuario.getEndereco());
        return repository.save(usuario);
    }
}
