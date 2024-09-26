package com.teste.pratico.mappers;

import com.teste.pratico.dtos.AgendamentoDTO;
import com.teste.pratico.entities.Agendamento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgendamentoMapper {

    private final ModelMapper modelMapper;
    private final SolicitanteMapper solicitantesMapper;

    public AgendamentoMapper(ModelMapper modelMapper, SolicitanteMapper solicitantesMapper) {
        this.modelMapper = modelMapper;
        this.solicitantesMapper = solicitantesMapper;
    }

    public AgendamentoDTO toDTO(Agendamento entity) {
        AgendamentoDTO dto = modelMapper.map(entity, AgendamentoDTO.class);
        dto.setSolicitanteId(solicitantesMapper.toDTO(entity.getSolicitante()));
        return dto;
    }

    public Agendamento toEntity(AgendamentoDTO dto) {
        Agendamento entity = modelMapper.map(dto, Agendamento.class);
        entity.setSolicitante(solicitantesMapper.toEntity(dto.getSolicitanteId()));
        return entity;
    }

    public List<AgendamentoDTO> toListDTO(List<Agendamento> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<Agendamento> toList(List<AgendamentoDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }

}