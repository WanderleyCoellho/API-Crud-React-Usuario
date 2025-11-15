package com.projeto.stay_agenda_api.Models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "agendamentos")
public class AgendamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String horaInicial;
    private String horaFinal;
    private String data;
    private String Observacoes;
    private Long idCliente;
    private Long idProcedimento;
    private String status;
    private BigDecimal valorParcial;
    private BigDecimal valorProcedimento;


    @OneToMany(mappedBy = "agendamentos")
    private List <MapeamentosModel> mapeamentos;


    @ManyToOne
    @JoinColumn(name = "clienteId")
    private ClientesModel clientes;

    @ManyToOne
    @JoinColumn(name = "procedimentoId")
    private ProcedimentosModel procedimentos;


    // --- Construtor ---
    public AgendamentosModel() {
    }

    public AgendamentosModel(String horaInicial, String horaFinal, String data, String observacoes, Long idCliente, Long idProcedimento, String status, BigDecimal valorParcial, BigDecimal valorProcedimento) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.data = data;
        Observacoes = observacoes;
        this.idCliente = idCliente;
        this.idProcedimento = idProcedimento;
        this.status = status;
        this.valorParcial = valorParcial;
        this.valorProcedimento = valorProcedimento;
    }

    // --- Getters e Setters ---
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(Long idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(BigDecimal valorParcial) {
        this.valorParcial = valorParcial;
    }

    public BigDecimal getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(BigDecimal valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

}
