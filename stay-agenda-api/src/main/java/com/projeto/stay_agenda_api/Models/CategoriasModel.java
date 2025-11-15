package com.projeto.stay_agenda_api.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "categorias")
public class CategoriasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;
    private String descricao;

    // --- Relacionamento --- Uma categoria pode ter varios procedimentos
    @OneToMany(mappedBy = "categoria")
    private List<ProcedimentosModel> procedimentos;

    // --- Construtor ---
    public CategoriasModel() {
    }

    public CategoriasModel(String categoria, String descricao) {
        this.categoria = categoria;
        this.descricao = descricao;
    }

    // --- Getters e Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setNome(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
