package com.teste.pratico.exceptions.vagas;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VagasNotFoundException extends ResponseStatusException {

    public VagasNotFoundException(){
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Vaga não encontrada com esse id");
    }

    public VagasNotFoundException(String message){
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }

}
