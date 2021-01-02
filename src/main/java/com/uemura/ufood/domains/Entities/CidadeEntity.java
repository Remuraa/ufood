package com.uemura.ufood.domains.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CidadeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String siglaEstado;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    private List<EnderecoEntity> enderecoEntities = new ArrayList();

    public CidadeEntity() {
    }

    public CidadeEntity(String nome, String siglaEstado) {
        this.nome = nome;
        this.siglaEstado = siglaEstado;
    }

    public Long getId() {
        return id;
    }

    public CidadeEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CidadeEntity setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public CidadeEntity setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
        return this;
    }

    public List<EnderecoEntity> getEnderecoEntities() {
        return enderecoEntities;
    }

    public CidadeEntity setEnderecoEntities(List<EnderecoEntity> enderecoEntities) {
        this.enderecoEntities = enderecoEntities;
        return this;
    }
}
