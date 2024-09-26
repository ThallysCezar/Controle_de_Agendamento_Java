package com.teste.pratico.exceptions.solicitantes;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SolicitantesException extends ResponseStatusException {

    public SolicitantesException(){
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Erro geral do Player");
    }

    public SolicitantesException(String message){
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

}
