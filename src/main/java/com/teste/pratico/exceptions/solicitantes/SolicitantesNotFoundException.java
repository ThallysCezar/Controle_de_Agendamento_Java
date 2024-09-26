package com.teste.pratico.exceptions.solicitantes;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SolicitantesNotFoundException extends ResponseStatusException {

    public SolicitantesNotFoundException(){
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Vaga não encontrada com esse id");
    }

    public SolicitantesNotFoundException(String message){
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }

}
