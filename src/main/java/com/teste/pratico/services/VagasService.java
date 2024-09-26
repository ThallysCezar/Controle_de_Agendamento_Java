package com.teste.pratico.services;

import com.teste.pratico.dtos.VagasDTO;
import com.teste.pratico.entities.Vagas;
import com.teste.pratico.exceptions.vagas.VagasException;
import com.teste.pratico.exceptions.vagas.VagasNotFoundException;
import com.teste.pratico.mappers.VagasMapper;
import com.teste.pratico.repositories.VagasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VagasService {

    private final VagasRepository vagasRepository;

    private final VagasMapper vagasMapper;

    public List<VagasDTO> findAll() {
        List<Vagas> vagasList = vagasRepository.findAll();
        if (vagasList.isEmpty()) {
            throw new VagasNotFoundException("Nenhuma vaga encontrada");
        }
        return vagasMapper.toListDTO(vagasList);
    }

    public VagasDTO save(VagasDTO dto) {
        try {
            if (dto.getInicio() == null || dto.getFim() == null || dto.getQuantidade() == null) {
                throw new VagasException("Data de início, data final e quantidade de vagas são obrigatórias.");
            }
            return vagasMapper.toDTO(vagasRepository.save(vagasMapper.toEntity(dto)));
        } catch (Exception exception) {
            throw new VagasException("Erro ao salvar vaga: " + exception.getMessage());
        }
    }

}