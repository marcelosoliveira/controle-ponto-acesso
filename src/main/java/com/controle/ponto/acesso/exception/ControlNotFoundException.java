package com.controle.ponto.acesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ControlNotFoundException extends RuntimeException {
    public ControlNotFoundException(String message) {
        super(message);
    }
}
