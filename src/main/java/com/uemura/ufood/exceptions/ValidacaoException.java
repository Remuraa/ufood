package com.uemura.ufood.exceptions;

import java.util.List;

public class ValidacaoException extends RuntimeException {

    private List<ErroException> erros;

    public ValidacaoException(List<ErroException> erros) {
        this.erros = erros;
    }

    public List<ErroException> getErros() {
        return erros;
    }

    @Override
    public String getMessage() {
        return erros.toString();
    }
}

