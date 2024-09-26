package com.teste.pratico.exceptions.vagas;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VagasException extends ResponseStatusException {

    public VagasException(){
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Erro geral do Player");
    }

    public VagasException(String message){
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

}
