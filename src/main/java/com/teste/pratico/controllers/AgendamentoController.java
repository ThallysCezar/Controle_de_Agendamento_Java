package com.teste.pratico.controllers;

import com.teste.pratico.dtos.AgendamentoDTO;
import com.teste.pratico.dtos.TotalAgendamentosPorSolicDTO;
import com.teste.pratico.services.AgendamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @GetMapping("/totalAgendamentos")
    public ResponseEntity<TotalAgendamentosPorSolicDTO> getTotalAgendamentosPorSolicitante(
            @RequestParam Long solicitanteId,
            @RequestParam Date inicio,
            @RequestParam Date fim) {

        TotalAgendamentosPorSolicDTO result = agendamentoService.getTotalAgendamentosPorSolicitante(solicitanteId, inicio, fim);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @RequestMapping("/listarTodosAgendamentos")
    public ResponseEntity<List<AgendamentoDTO>> findAll() {
        return ResponseEntity.ok().body(agendamentoService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/cadastro_de_agendamento")
    public void save(@Valid @RequestBody AgendamentoDTO dto) {
        agendamentoService.save(dto);
    }

}