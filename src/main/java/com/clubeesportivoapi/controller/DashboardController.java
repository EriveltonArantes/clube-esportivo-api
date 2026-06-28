package com.clubeesportivoapi.controller;

import com.clubeesportivoapi.model.Atleta;
import com.clubeesportivoapi.model.Modalidade;
import com.clubeesportivoapi.model.Competicao;
import com.clubeesportivoapi.model.Resultado;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.clubeesportivoapi.repository.AtletaRepository atletaRepository;

    @Autowired
    private com.clubeesportivoapi.repository.ModalidadeRepository modalidadeRepository;

    @Autowired
    private com.clubeesportivoapi.repository.CompeticaoRepository competicaoRepository;

    @Autowired
    private com.clubeesportivoapi.repository.ResultadoRepository resultadoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalAtleta", atletaRepository.count());
        resumo.put("totalModalidade", modalidadeRepository.count());
        resumo.put("somaMensalidadeModalidade", modalidadeRepository.findAll().stream().map(e -> e.getMensalidade()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("totalCompeticao", competicaoRepository.count());
        resumo.put("graficoCompeticao", competicaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalResultado", resultadoRepository.count());
        resumo.put("somaPosicaoResultado", resultadoRepository.findAll().stream().filter(e -> e.getPosicao() != null).mapToInt(e -> e.getPosicao()).sum());
        return resumo;
    }
}
