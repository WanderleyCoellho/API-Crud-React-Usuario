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
@Table(name = "procedimentos")
public class ProcedimentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    // --- Relacionamento --- Um procedimento tem uma unica categoria
    @ManyToOne
    // Foreign Key/Chave Estrangeira --- ou seja a coluna que referencia a outra tabela
    @JoinColumn(name = "categoriaId")
    private CategoriasModel categoria;


    @OneToMany(mappedBy = "procedimento")
    private List<PromocoesModel> promocao;

    @OneToMany(mappedBy = "procedimentos")
    private List<MapeamentosModel> mapeamentos;

    @OneToMany(mappedBy = "procedimentos")
    private List<AgendamentosModel> agendamentos;

    private Long idCategoria;
    private String procedimento;
    private String descricao;
    private BigDecimal valor;

    // --- Construtor ---
    public ProcedimentosModel() {
    }

    public ProcedimentosModel(CategoriasModel categoria, Long idCategoria, String procedimento, String descricao, BigDecimal valor) {
        this.categoria = categoria;
        this.idCategoria = idCategoria;
        this.procedimento = procedimento;
        this.descricao = descricao;
        this.valor = valor;
    }

    // --- Getters e Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setNome(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setPreco( BigDecimal valor) {
        this.valor = valor;
    }

    public CategoriasModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasModel categoria) {
        this.categoria = categoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
