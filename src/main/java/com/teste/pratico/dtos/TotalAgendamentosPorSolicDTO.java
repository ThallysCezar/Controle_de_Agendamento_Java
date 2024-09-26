package com.teste.pratico.dtos;

public class TotalAgendamentosPorSolicDTO {

    private Long solicitanteId;

    private Long totalAgendamentos;

    private Long percentual;

    public TotalAgendamentosPorSolicDTO() {
    }

    public TotalAgendamentosPorSolicDTO(Long solicitanteId, Long totalAgendamentos, Long percentual) {
        this.solicitanteId = solicitanteId;
        this.totalAgendamentos = totalAgendamentos;
        this.percentual = percentual;
    }

    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Long getTotalAgendamentos() {
        return totalAgendamentos;
    }

    public void setTotalAgendamentos(Long totalAgendamentos) {
        this.totalAgendamentos = totalAgendamentos;
    }

    public Long getPercentual() {
        return percentual;
    }

    public void setPercentual(Long percentual) {
        this.percentual = percentual;
    }

}