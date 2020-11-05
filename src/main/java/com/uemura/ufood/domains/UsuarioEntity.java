package com.uemura.ufood.domains;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String sobrenome;
    @NotEmpty
    private String usuario;
    @ManyToOne
    @JoinColumn(name = "idendereco")
    private EnderecoEntity endereco;

    public Long getId() {
        return id;
    }

    public UsuarioEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public UsuarioEntity setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public UsuarioEntity setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getUsuario() {
        return usuario;
    }

    public UsuarioEntity setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public UsuarioEntity setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
        return this;
    }
}
