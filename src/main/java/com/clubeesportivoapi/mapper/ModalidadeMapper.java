package com.clubeesportivoapi.mapper;

import com.clubeesportivoapi.dto.ModalidadeRequestDTO;
import com.clubeesportivoapi.dto.ModalidadeResponseDTO;
import com.clubeesportivoapi.model.Modalidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModalidadeMapper {

    Modalidade toEntity(ModalidadeRequestDTO dto);

    ModalidadeResponseDTO toResponseDTO(Modalidade entity);
}
