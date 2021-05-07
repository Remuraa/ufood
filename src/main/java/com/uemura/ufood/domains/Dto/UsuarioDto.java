package com.uemura.ufood.domains.Dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;
    private String token;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String siglaEstado;

    public String getNome() {
        return nome;
    }

    public UsuarioDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public UsuarioDto setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getUsuario() {
        return usuario;
    }

    public UsuarioDto setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioDto setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UsuarioDto setToken(String token) {
        this.token = token;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public UsuarioDto setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public UsuarioDto setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public UsuarioDto setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public UsuarioDto setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public UsuarioDto setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
        return this;
    }
}
