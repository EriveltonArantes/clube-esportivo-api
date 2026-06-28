package com.clubeesportivoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "competicao_id")
    private Competicao competicao;
    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private Atleta atleta;
    private Integer posicao;
    private Double pontos;
    @Column(nullable = false)
    private String medalha;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Competicao getCompeticao() { return competicao; }
    public void setCompeticao(Competicao competicao) { this.competicao = competicao; }
    public Atleta getAtleta() { return atleta; }
    public void setAtleta(Atleta atleta) { this.atleta = atleta; }
    public Integer getPosicao() { return posicao; }
    public void setPosicao(Integer posicao) { this.posicao = posicao; }
    public Double getPontos() { return pontos; }
    public void setPontos(Double pontos) { this.pontos = pontos; }
    public String getMedalha() { return medalha; }
    public void setMedalha(String medalha) { this.medalha = medalha; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
