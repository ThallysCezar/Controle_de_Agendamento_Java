package com.teste.pratico.controllers;

import com.teste.pratico.dtos.VagasDTO;
import com.teste.pratico.services.VagasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vagas")
public class VagasController {

    private final VagasService vagasService;

    @GetMapping
    @RequestMapping("/listarTodasVagas")
    public ResponseEntity<List<VagasDTO>> findAll() {
        return ResponseEntity.ok().body(vagasService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/cadastro_de_vagas")
    public void save(@Valid @RequestBody VagasDTO dto) {
        vagasService.save(dto);
    }

}