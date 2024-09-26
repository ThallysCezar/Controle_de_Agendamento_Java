package com.teste.pratico.services;

import com.teste.pratico.dtos.SolicitanteDTO;
import com.teste.pratico.entities.Solicitante;
import com.teste.pratico.exceptions.solicitantes.SolicitantesException;
import com.teste.pratico.exceptions.vagas.VagasNotFoundException;
import com.teste.pratico.mappers.SolicitanteMapper;
import com.teste.pratico.repositories.SolicitanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolicitanteService {

    private final SolicitanteRepository solicitanteRepository;

    private final SolicitanteMapper solicitanteMapper;

    public List<SolicitanteDTO> findAll() {
        List<Solicitante> solicitantes = solicitanteRepository.findAll();
        if (solicitantes.isEmpty()) {
            throw new VagasNotFoundException("Nenhuma vaga encontrada");
        }
        return solicitanteMapper.toListDTO(solicitantes);
    }

    public SolicitanteDTO save(SolicitanteDTO dto) {
        try {
            if (dto.getNome() == null) {
                throw new SolicitantesException("Nome é obrigatório");
            }
            return solicitanteMapper.toDTO(solicitanteRepository.save(solicitanteMapper.toEntity(dto)));
        } catch (Exception exception) {
            throw new SolicitantesException("Erro ao salvar solicitantes: " + exception.getMessage());
        }
    }

}