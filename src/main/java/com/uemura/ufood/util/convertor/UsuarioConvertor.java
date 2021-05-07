package com.uemura.ufood.util.convertor;

import com.uemura.ufood.domains.Dto.UsuarioDto;
import com.uemura.ufood.domains.Entities.CidadeEntity;
import com.uemura.ufood.domains.Entities.EnderecoEntity;
import com.uemura.ufood.domains.Entities.UsuarioEntity;

public class UsuarioConvertor {

    public static UsuarioEntity converter(UsuarioDto usuarioDto){
        return new UsuarioEntity()
                .setNome(usuarioDto.getNome())
                .setSobrenome(usuarioDto.getSobrenome())
                .setUsuario(usuarioDto.getUsuario())
                .setSenha(usuarioDto.getSenha())
                .setEndereco(obterEndereco(usuarioDto));
    }

    private static EnderecoEntity obterEndereco(UsuarioDto usuarioDto){
        return new EnderecoEntity()
                .setRua(usuarioDto.getRua())
                .setBairro(usuarioDto.getBairro())
                .setNumero(usuarioDto.getNumero())
                .setCidade(obterCidade(usuarioDto.getCidade(), usuarioDto.getSiglaEstado()));
    }

    private static CidadeEntity obterCidade(String cidade, String sigla){
        return new CidadeEntity()
                .setNome(cidade)
                .setSiglaEstado(sigla);
    }
}
