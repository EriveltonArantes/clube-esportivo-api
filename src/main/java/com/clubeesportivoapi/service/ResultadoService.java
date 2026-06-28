package com.clubeesportivoapi.service;

import com.clubeesportivoapi.dto.ResultadoRequestDTO;
import com.clubeesportivoapi.dto.ResultadoResponseDTO;
import com.clubeesportivoapi.exception.ResourceNotFoundException;
import com.clubeesportivoapi.mapper.ResultadoMapper;
import com.clubeesportivoapi.model.Resultado;
import com.clubeesportivoapi.repository.ResultadoRepository;
import com.clubeesportivoapi.repository.CompeticaoRepository;
import com.clubeesportivoapi.model.Competicao;
import com.clubeesportivoapi.repository.AtletaRepository;
import com.clubeesportivoapi.model.Atleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ResultadoService {

    @Autowired
    private ResultadoRepository repository;

    @Autowired
    private ResultadoMapper mapper;

    @Autowired
    private CompeticaoRepository competicaoRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    @Transactional(readOnly = true)
    public List<ResultadoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResultadoResponseDTO buscar(Long id) {
        Resultado entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Resultado não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ResultadoResponseDTO criar(ResultadoRequestDTO dto) {
        Resultado entity = mapper.toEntity(dto);
        Competicao competicao = competicaoRepository.findById(dto.getCompeticaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Competicao não encontrado com id: " + dto.getCompeticaoId()));
        entity.setCompeticao(competicao);
        Atleta atleta = atletaRepository.findById(dto.getAtletaId())
            .orElseThrow(() -> new ResourceNotFoundException("Atleta não encontrado com id: " + dto.getAtletaId()));
        entity.setAtleta(atleta);
        Resultado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ResultadoResponseDTO atualizar(Long id, ResultadoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resultado não encontrado com id: " + id);
        }
        Resultado entity = mapper.toEntity(dto);
        entity.setId(id);
        Competicao competicao = competicaoRepository.findById(dto.getCompeticaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Competicao não encontrado com id: " + dto.getCompeticaoId()));
        entity.setCompeticao(competicao);
        Atleta atleta = atletaRepository.findById(dto.getAtletaId())
            .orElseThrow(() -> new ResourceNotFoundException("Atleta não encontrado com id: " + dto.getAtletaId()));
        entity.setAtleta(atleta);
        Resultado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resultado não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
