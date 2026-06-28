package com.clubeesportivoapi.controller;

import com.clubeesportivoapi.dto.ResultadoRequestDTO;
import com.clubeesportivoapi.dto.ResultadoResponseDTO;
import com.clubeesportivoapi.service.ResultadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Resultado", description = "Gerenciamento de resultados")
@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService service;

    @Operation(summary = "Listar todos os Resultado")
    @GetMapping
    public List<ResultadoResponseDTO> listar(@RequestParam(required = false) String medalha, @RequestParam(required = false) Long competicaoId, @RequestParam(required = false) Long atletaId) {
        List<ResultadoResponseDTO> resultado = service.listar();
        if (medalha != null && !medalha.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getMedalha() != null &&
                item.getMedalha().toLowerCase().contains(medalha.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (competicaoId != null) {
            resultado = resultado.stream().filter(item -> competicaoId.equals(item.getCompeticaoId())).collect(java.util.stream.Collectors.toList());
        }
        if (atletaId != null) {
            resultado = resultado.stream().filter(item -> atletaId.equals(item.getAtletaId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Resultado por ID")
    @GetMapping("/{id}")
    public ResultadoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Resultado")
    @PostMapping
    public ResponseEntity<ResultadoResponseDTO> criar(@Valid @RequestBody ResultadoRequestDTO resultado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(resultado));
    }

    @Operation(summary = "Atualizar Resultado")
    @PutMapping("/{id}")
    public ResultadoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ResultadoRequestDTO resultado) {
        return service.atualizar(id, resultado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Resultado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
