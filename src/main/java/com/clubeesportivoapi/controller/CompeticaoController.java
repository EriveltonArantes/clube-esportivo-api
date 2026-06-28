package com.clubeesportivoapi.controller;

import com.clubeesportivoapi.dto.CompeticaoRequestDTO;
import com.clubeesportivoapi.dto.CompeticaoResponseDTO;
import com.clubeesportivoapi.service.CompeticaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Competicao", description = "Gerenciamento de competicaos")
@RestController
@RequestMapping("/api/competicaos")
public class CompeticaoController {

    @Autowired
    private CompeticaoService service;

    @Operation(summary = "Listar todos os Competicao")
    @GetMapping
    public List<CompeticaoResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long modalidadeId) {
        List<CompeticaoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (modalidadeId != null) {
            resultado = resultado.stream().filter(item -> modalidadeId.equals(item.getModalidadeId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Competicao por ID")
    @GetMapping("/{id}")
    public CompeticaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Competicao")
    @PostMapping
    public ResponseEntity<CompeticaoResponseDTO> criar(@Valid @RequestBody CompeticaoRequestDTO competicao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(competicao));
    }

    @Operation(summary = "Atualizar Competicao")
    @PutMapping("/{id}")
    public CompeticaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CompeticaoRequestDTO competicao) {
        return service.atualizar(id, competicao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Competicao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
