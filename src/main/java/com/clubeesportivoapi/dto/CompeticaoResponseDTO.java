package com.clubeesportivoapi.dto;

public class CompeticaoResponseDTO {

    private Long id;
    private Long modalidadeId;
    private String nome;
    private String local;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataFim;
    private String tipo;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getModalidadeId() { return modalidadeId; }
    public void setModalidadeId(Long modalidadeId) { this.modalidadeId = modalidadeId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public java.time.LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(java.time.LocalDateTime dataFim) { this.dataFim = dataFim; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
