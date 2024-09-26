package com.teste.pratico.controllers;

import com.teste.pratico.dtos.SolicitanteDTO;
import com.teste.pratico.services.SolicitanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/solicitante")
public class SolicitanteController {

    private final SolicitanteService solicitanteService;

    @GetMapping
    @RequestMapping("/listarTodosSolicitantes")
    public ResponseEntity<List<SolicitanteDTO>> findAll() {
        return ResponseEntity.ok().body(solicitanteService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/cadastro_de_solicitantes")
    public void save(@Valid @RequestBody SolicitanteDTO dto) {
        solicitanteService.save(dto);
    }

}