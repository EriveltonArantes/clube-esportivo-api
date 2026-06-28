package com.clubeesportivoapi.dto;

import jakarta.validation.constraints.*;

public class ResultadoRequestDTO {

    @NotNull(message = "CompeticaoId é obrigatório")
    @Positive(message = "CompeticaoId deve ser um ID válido (positivo)")
    private Long competicaoId;
    @NotNull(message = "AtletaId é obrigatório")
    @Positive(message = "AtletaId deve ser um ID válido (positivo)")
    private Long atletaId;
    @NotNull(message = "posicao não pode ser nulo")
    private Integer posicao;
    @NotNull(message = "pontos não pode ser nulo")
    private Double pontos;
    @NotBlank(message = "medalha não pode estar em branco")
    private String medalha;

    private String observacoes;

    public Long getCompeticaoId() { return competicaoId; }
    public void setCompeticaoId(Long competicaoId) { this.competicaoId = competicaoId; }
    public Long getAtletaId() { return atletaId; }
    public void setAtletaId(Long atletaId) { this.atletaId = atletaId; }
    public Integer getPosicao() { return posicao; }
    public void setPosicao(Integer posicao) { this.posicao = posicao; }
    public Double getPontos() { return pontos; }
    public void setPontos(Double pontos) { this.pontos = pontos; }
    public String getMedalha() { return medalha; }
    public void setMedalha(String medalha) { this.medalha = medalha; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
