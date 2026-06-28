package com.clubeesportivoapi.dto;

public class ModalidadeResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String treinador;
    private String local;
    private String diasSemana;
    private String horario;
    private java.math.BigDecimal mensalidade;
    private Boolean ativa;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getTreinador() { return treinador; }
    public void setTreinador(String treinador) { this.treinador = treinador; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public String getDiasSemana() { return diasSemana; }
    public void setDiasSemana(String diasSemana) { this.diasSemana = diasSemana; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public java.math.BigDecimal getMensalidade() { return mensalidade; }
    public void setMensalidade(java.math.BigDecimal mensalidade) { this.mensalidade = mensalidade; }
    public Boolean getAtiva() { return ativa; }
    public void setAtiva(Boolean ativa) { this.ativa = ativa; }
}
