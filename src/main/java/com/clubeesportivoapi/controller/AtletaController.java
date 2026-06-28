package com.clubeesportivoapi.controller;

import com.clubeesportivoapi.dto.AtletaRequestDTO;
import com.clubeesportivoapi.dto.AtletaResponseDTO;
import com.clubeesportivoapi.service.AtletaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Atleta", description = "Gerenciamento de atletas")
@RestController
@RequestMapping("/api/atletas")
public class AtletaController {

    @Autowired
    private AtletaService service;

    @Operation(summary = "Listar todos os Atleta")
    @GetMapping
    public List<AtletaResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long modalidadeId) {
        List<AtletaResponseDTO> resultado = service.listar();
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

    @Operation(summary = "Buscar Atleta por ID")
    @GetMapping("/{id}")
    public AtletaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Atleta")
    @PostMapping
    public ResponseEntity<AtletaResponseDTO> criar(@Valid @RequestBody AtletaRequestDTO atleta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(atleta));
    }

    @Operation(summary = "Atualizar Atleta")
    @PutMapping("/{id}")
    public AtletaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AtletaRequestDTO atleta) {
        return service.atualizar(id, atleta);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Atleta")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
