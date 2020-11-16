package com.uemura.ufood.domains.Dto;

import java.io.Serializable;

public class LoginDto implements Serializable {

    private String login;
    private String senha;
    private String token;

    public String getLogin() {
        return login;
    }

    public LoginDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public LoginDto setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getToken() {
        return token;
    }

    public LoginDto setToken(String token) {
        this.token = token;
        return this;
    }
}
