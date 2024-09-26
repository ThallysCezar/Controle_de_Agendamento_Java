package com.teste.pratico.mappers;

import com.teste.pratico.dtos.SolicitanteDTO;
import com.teste.pratico.entities.Solicitante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SolicitanteMapper {

    private final ModelMapper modelMapper;

    public SolicitanteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SolicitanteDTO toDTO(Solicitante entity) {
        return modelMapper.map(entity, SolicitanteDTO.class);
    }

    public Solicitante toEntity(SolicitanteDTO dto) {
        return modelMapper.map(dto, Solicitante.class);
    }

    public List<SolicitanteDTO> toListDTO(List<Solicitante> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<Solicitante> toList(List<SolicitanteDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }

}