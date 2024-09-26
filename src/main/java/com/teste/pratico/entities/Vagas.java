package com.teste.pratico.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Vagas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data de início é obrigatória")
    private Date inicio;

    @NotNull(message = "A data final é obrigatória")
    private Date fim;

    @NotNull(message = "A quantidade de vagas é obrigatória")
    @Min(value = 1, message = "A quantidade de vagas deve ser no mínimo 1")
    private Long quantidade;

    public Vagas() {
    }

    public Vagas(Long id, Date inicio, Date fim, Long quantidade) {
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

    public void setInicio(Date dataInicio) {
        this.inicio = dataInicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date dataFim) {
        this.fim = dataFim;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

}