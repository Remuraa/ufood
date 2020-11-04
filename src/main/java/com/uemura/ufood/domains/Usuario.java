package com.uemura.ufood.domains;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

}
