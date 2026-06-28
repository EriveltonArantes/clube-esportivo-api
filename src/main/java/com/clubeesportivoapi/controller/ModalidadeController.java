package com.clubeesportivoapi.controller;

import com.clubeesportivoapi.dto.ModalidadeRequestDTO;
import com.clubeesportivoapi.dto.ModalidadeResponseDTO;
import com.clubeesportivoapi.service.ModalidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Modalidade", description = "Gerenciamento de modalidades")
@RestController
@RequestMapping("/api/modalidades")
public class ModalidadeController {

    @Autowired
    private ModalidadeService service;

    @Operation(summary = "Listar todos os Modalidade")
    @GetMapping
    public List<ModalidadeResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<ModalidadeResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Modalidade por ID")
    @GetMapping("/{id}")
    public ModalidadeResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Modalidade")
    @PostMapping
    public ResponseEntity<ModalidadeResponseDTO> criar(@Valid @RequestBody ModalidadeRequestDTO modalidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(modalidade));
    }

    @Operation(summary = "Atualizar Modalidade")
    @PutMapping("/{id}")
    public ModalidadeResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ModalidadeRequestDTO modalidade) {
        return service.atualizar(id, modalidade);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Modalidade")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
