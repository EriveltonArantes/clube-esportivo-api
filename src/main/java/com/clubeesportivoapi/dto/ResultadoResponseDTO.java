package com.clubeesportivoapi.dto;

public class ResultadoResponseDTO {

    private Long id;
    private Long competicaoId;
    private Long atletaId;
    private Integer posicao;
    private Double pontos;
    private String medalha;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
