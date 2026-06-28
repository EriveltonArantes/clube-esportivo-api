package com.clubeesportivoapi.mapper;

import com.clubeesportivoapi.dto.ResultadoRequestDTO;
import com.clubeesportivoapi.dto.ResultadoResponseDTO;
import com.clubeesportivoapi.model.Resultado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResultadoMapper {

    @Mapping(target = "competicao", ignore = true)
    @Mapping(target = "atleta", ignore = true)
    Resultado toEntity(ResultadoRequestDTO dto);

    @Mapping(target = "competicaoId", source = "competicao.id")
    @Mapping(target = "atletaId", source = "atleta.id")
    ResultadoResponseDTO toResponseDTO(Resultado entity);
}
