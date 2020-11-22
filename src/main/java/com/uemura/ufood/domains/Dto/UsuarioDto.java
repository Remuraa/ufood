package com.uemura.ufood.domains.Dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public UsuarioDto setId(Long id) {
        this.id = id;
        return this;
    }
}
