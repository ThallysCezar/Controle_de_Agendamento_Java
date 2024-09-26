package com.teste.pratico.exceptions.agendamentos;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AgendamentoNotFoundException extends ResponseStatusException {

    public AgendamentoNotFoundException(){
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Vaga não encontrada com esse id");
    }

    public AgendamentoNotFoundException(String message){
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }

}
