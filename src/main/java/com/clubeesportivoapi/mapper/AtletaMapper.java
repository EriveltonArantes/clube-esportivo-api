package com.clubeesportivoapi.mapper;

import com.clubeesportivoapi.dto.AtletaRequestDTO;
import com.clubeesportivoapi.dto.AtletaResponseDTO;
import com.clubeesportivoapi.model.Atleta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AtletaMapper {

    @Mapping(target = "modalidade", ignore = true)
    Atleta toEntity(AtletaRequestDTO dto);

    @Mapping(target = "modalidadeId", source = "modalidade.id")
    AtletaResponseDTO toResponseDTO(Atleta entity);
}
