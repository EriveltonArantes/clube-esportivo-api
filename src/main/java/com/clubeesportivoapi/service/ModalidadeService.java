package com.clubeesportivoapi.service;

import com.clubeesportivoapi.dto.ModalidadeRequestDTO;
import com.clubeesportivoapi.dto.ModalidadeResponseDTO;
import com.clubeesportivoapi.exception.ResourceNotFoundException;
import com.clubeesportivoapi.mapper.ModalidadeMapper;
import com.clubeesportivoapi.model.Modalidade;
import com.clubeesportivoapi.repository.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ModalidadeService {

    @Autowired
    private ModalidadeRepository repository;

    @Autowired
    private ModalidadeMapper mapper;

    @Transactional(readOnly = true)
    public List<ModalidadeResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ModalidadeResponseDTO buscar(Long id) {
        Modalidade entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Modalidade não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ModalidadeResponseDTO criar(ModalidadeRequestDTO dto) {
        Modalidade entity = mapper.toEntity(dto);
        Modalidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ModalidadeResponseDTO atualizar(Long id, ModalidadeRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Modalidade não encontrado com id: " + id);
        }
        Modalidade entity = mapper.toEntity(dto);
        entity.setId(id);
        Modalidade salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Modalidade não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
