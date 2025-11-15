package com.projeto.stay_agenda_api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Diz ao Spring que esta classe é uma tabela
@Table(name = "usuario") // Diz o nome da tabela no MySQL
public class UsuariosModel {

    @Id // Marca como Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usa o AUTO_INCREMENT do MySQL
    private Long id;

    private String nome;
    private String senha; // O hash da senha

    // Construtor vazio (Obrigatório para o JPA)
    public UsuariosModel() {
    }

    // --- Getters e Setters ---
    // (Obrigatórios para o JPA)
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}