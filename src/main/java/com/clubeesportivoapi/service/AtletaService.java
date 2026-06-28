package com.clubeesportivoapi.service;

import com.clubeesportivoapi.dto.AtletaRequestDTO;
import com.clubeesportivoapi.dto.AtletaResponseDTO;
import com.clubeesportivoapi.exception.ResourceNotFoundException;
import com.clubeesportivoapi.mapper.AtletaMapper;
import com.clubeesportivoapi.model.Atleta;
import com.clubeesportivoapi.repository.AtletaRepository;
import com.clubeesportivoapi.repository.ModalidadeRepository;
import com.clubeesportivoapi.model.Modalidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AtletaService {

    @Autowired
    private AtletaRepository repository;

    @Autowired
    private AtletaMapper mapper;

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @Transactional(readOnly = true)
    public List<AtletaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AtletaResponseDTO buscar(Long id) {
        Atleta entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Atleta não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AtletaResponseDTO criar(AtletaRequestDTO dto) {
        Atleta entity = mapper.toEntity(dto);
        Modalidade modalidade = modalidadeRepository.findById(dto.getModalidadeId())
            .orElseThrow(() -> new ResourceNotFoundException("Modalidade não encontrado com id: " + dto.getModalidadeId()));
        entity.setModalidade(modalidade);
        Atleta salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AtletaResponseDTO atualizar(Long id, AtletaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Atleta não encontrado com id: " + id);
        }
        Atleta entity = mapper.toEntity(dto);
        entity.setId(id);
        Modalidade modalidade = modalidadeRepository.findById(dto.getModalidadeId())
            .orElseThrow(() -> new ResourceNotFoundException("Modalidade não encontrado com id: " + dto.getModalidadeId()));
        entity.setModalidade(modalidade);
        Atleta salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Atleta não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
