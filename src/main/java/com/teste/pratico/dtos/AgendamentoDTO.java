package com.teste.pratico.dtos;

import java.util.Date;

public class AgendamentoDTO {

    private Long id;

    private Date data;

    private String numero;

    private String motivo;

    // FK de solicitante
    private SolicitanteDTO solicitanteId;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long id, Date data, String numero, String motivo, SolicitanteDTO solicitanteId) {
        this.id = id;
        this.data = data;
        this.numero = numero;
        this.motivo = motivo;
        this.solicitanteId = solicitanteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public SolicitanteDTO getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(SolicitanteDTO solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

}