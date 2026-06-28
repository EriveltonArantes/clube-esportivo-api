package com.clubeesportivoapi.dto;

public class AtletaResponseDTO {

    private Long id;
    private Long modalidadeId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private java.time.LocalDate dataNascimento;
    private String categoria;
    private Boolean federado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getModalidadeId() { return modalidadeId; }
    public void setModalidadeId(Long modalidadeId) { this.modalidadeId = modalidadeId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public java.time.LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Boolean getFederado() { return federado; }
    public void setFederado(Boolean federado) { this.federado = federado; }
}
