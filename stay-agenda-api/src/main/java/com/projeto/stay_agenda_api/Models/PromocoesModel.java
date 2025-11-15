package com.projeto.stay_agenda_api.Models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "promocoes")
public class PromocoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String dataInicio;
    private String dataFim;
    private String descricao;
    BigDecimal valorPromocional;
    private String statusPromocao;

    
    @ManyToOne
    @JoinColumn(name = "procedimentoId")
    private ProcedimentosModel procedimento;

    // --- Construtor ---
    public PromocoesModel() {
    }

    public PromocoesModel(String titulo, String dataInicio, String dataFim, String descricao, BigDecimal valorPromocional, String statusPromocao, ProcedimentosModel procedimento) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.valorPromocional = valorPromocional;
        this.statusPromocao = statusPromocao;
        this.procedimento = procedimento;
    }

    // --- Getters e Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public BigDecimal getValorPromocional() {
        return valorPromocional;
    }

    public void setValorPromocional(BigDecimal valorPromocional) {
        this.valorPromocional = valorPromocional;
    }

    public String getStatusPromocao() {
        return statusPromocao;
    }

    public void setStatusPromocao(String statusPromocao) {
        this.statusPromocao = statusPromocao;
    }

    public ProcedimentosModel getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(ProcedimentosModel procedimento) {
        this.procedimento = procedimento;
    }
}
