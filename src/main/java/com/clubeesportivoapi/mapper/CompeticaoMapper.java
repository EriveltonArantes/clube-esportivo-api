package com.clubeesportivoapi.mapper;

import com.clubeesportivoapi.dto.CompeticaoRequestDTO;
import com.clubeesportivoapi.dto.CompeticaoResponseDTO;
import com.clubeesportivoapi.model.Competicao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompeticaoMapper {

    @Mapping(target = "modalidade", ignore = true)
    Competicao toEntity(CompeticaoRequestDTO dto);

    @Mapping(target = "modalidadeId", source = "modalidade.id")
    CompeticaoResponseDTO toResponseDTO(Competicao entity);
}
