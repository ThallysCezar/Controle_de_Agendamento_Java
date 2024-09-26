package com.teste.pratico.dtos;

import java.util.Date;

public class VagasDTO {

    private Long id;

    private Date inicio;

    private Date fim;

    private Long quantidade;

    public VagasDTO() {
    }

    public VagasDTO(Long id, Date inicio, Date fim, Long quantidade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
