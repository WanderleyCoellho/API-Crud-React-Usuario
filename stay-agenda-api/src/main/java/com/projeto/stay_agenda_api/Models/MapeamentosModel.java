package com.projeto.stay_agenda_api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "mapeamentos")
public class MapeamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private byte[] imagem;

    @ManyToOne
    @JoinColumn(name = "procedimentoId")
    private ProcedimentosModel procedimentos;
    
    @ManyToOne
    @JoinColumn(name = "agendamentoId")
    private AgendamentosModel agendamentos;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private ClientesModel clientes;

    // --- Construtor ---
    public MapeamentosModel() {
    }

    public MapeamentosModel( String descricao, byte[] imagem) {
        this.descricao = descricao;
        this.imagem = imagem;
    }

    // --- Getters e Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
}
