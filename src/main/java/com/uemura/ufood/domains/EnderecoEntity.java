package com.uemura.ufood.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String bairro;
    private String numero;
    @ManyToOne
    @JoinColumn(name = "idcidade")
    private CidadeEntity cidade;

    @OneToMany(mappedBy = "endereco")
    private List<UsuarioEntity> enderecoEntities = new ArrayList();

    public Long getId() {
        return id;
    }

    public EnderecoEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public EnderecoEntity setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public EnderecoEntity setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public EnderecoEntity setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public CidadeEntity getCidade() {
        return cidade;
    }

    public EnderecoEntity setCidade(CidadeEntity cidade) {
        this.cidade = cidade;
        return this;
    }
}
