package com.projeto.stay_agenda_api.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes") 
public class ClientesModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String documento; // CPF ou CNPJ
    private String email;
    private String redesocial;
    private String telefone;
    private String telefone2;

    @OneToMany(mappedBy = "clientes")
    private List<MapeamentosModel> mapeamentos;
    
    @OneToMany(mappedBy = "clientes")
    private List<AgendamentosModel> agendamentos;

    
    // --- Construtor ---
    public ClientesModel() {
    }

    public ClientesModel(String nome, String documento, String email, String redesocial, String telefone, String telefone2) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.redesocial = redesocial;
        this.telefone = telefone;
        this.telefone2 = telefone2;
    }

    // --- Getters e Setters --- 
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRedesocial() {
        return redesocial;
    }
    public void setRedesocial(String redesocial) {
        this.redesocial = redesocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
}