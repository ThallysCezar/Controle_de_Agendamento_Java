package com.teste.pratico.exceptions.agendamentos;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AgendamentoException extends ResponseStatusException {

    public AgendamentoException(){
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Erro geral do Player");
    }

    public AgendamentoException(String message){
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

}
