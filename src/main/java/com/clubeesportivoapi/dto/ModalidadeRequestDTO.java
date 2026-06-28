package com.clubeesportivoapi.dto;

import jakarta.validation.constraints.*;

public class ModalidadeRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "treinador não pode estar em branco")
    private String treinador;
    @NotBlank(message = "local não pode estar em branco")
    private String local;
    @NotBlank(message = "dias semana não pode estar em branco")
    private String diasSemana;
    @NotBlank(message = "horario não pode estar em branco")
    private String horario;
    @DecimalMin(value = "0.0", message = "mensalidade não pode ser negativo")
    @NotNull(message = "mensalidade não pode ser nulo")
    private java.math.BigDecimal mensalidade;
    @NotNull(message = "ativa não pode ser nulo")
    private Boolean ativa;

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
