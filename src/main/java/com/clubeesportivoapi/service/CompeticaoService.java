package com.clubeesportivoapi.service;

import com.clubeesportivoapi.dto.CompeticaoRequestDTO;
import com.clubeesportivoapi.dto.CompeticaoResponseDTO;
import com.clubeesportivoapi.exception.ResourceNotFoundException;
import com.clubeesportivoapi.mapper.CompeticaoMapper;
import com.clubeesportivoapi.model.Competicao;
import com.clubeesportivoapi.repository.CompeticaoRepository;
import com.clubeesportivoapi.repository.ModalidadeRepository;
import com.clubeesportivoapi.model.Modalidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompeticaoService {

    @Autowired
    private CompeticaoRepository repository;

    @Autowired
    private CompeticaoMapper mapper;

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @Transactional(readOnly = true)
    public List<CompeticaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CompeticaoResponseDTO buscar(Long id) {
        Competicao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Competicao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CompeticaoResponseDTO criar(CompeticaoRequestDTO dto) {
        Competicao entity = mapper.toEntity(dto);
        Modalidade modalidade = modalidadeRepository.findById(dto.getModalidadeId())
            .orElseThrow(() -> new ResourceNotFoundException("Modalidade não encontrado com id: " + dto.getModalidadeId()));
        entity.setModalidade(modalidade);
        Competicao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CompeticaoResponseDTO atualizar(Long id, CompeticaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Competicao não encontrado com id: " + id);
        }
        Competicao entity = mapper.toEntity(dto);
        entity.setId(id);
        Modalidade modalidade = modalidadeRepository.findById(dto.getModalidadeId())
            .orElseThrow(() -> new ResourceNotFoundException("Modalidade não encontrado com id: " + dto.getModalidadeId()));
        entity.setModalidade(modalidade);
        Competicao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Competicao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
