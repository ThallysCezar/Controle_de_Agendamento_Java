package com.teste.pratico.mappers;

import com.teste.pratico.dtos.VagasDTO;
import com.teste.pratico.entities.Vagas;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VagasMapper {

    private final ModelMapper modelMapper;

    public VagasMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VagasDTO toDTO(Vagas entity) {
        return modelMapper.map(entity, VagasDTO.class);
    }

    public Vagas toEntity(VagasDTO dto) {
        return modelMapper.map(dto, Vagas.class);
    }

    public List<VagasDTO> toListDTO(List<Vagas> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<Vagas> toList(List<VagasDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }

}