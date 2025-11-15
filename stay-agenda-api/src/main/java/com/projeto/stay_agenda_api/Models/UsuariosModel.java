package com.projeto.stay_agenda_api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Diz ao Spring que esta classe é uma tabela
@Table(name = "usuario") // Diz o nome da tabela no MySQL
@Data // Gera Getters, Setters, toString, equals e hashCode automaticamente
@AllArgsConstructor // Gera um construtor com todos os campos
@NoArgsConstructor // Gera um construtor vazio
public class UsuariosModel {

    @Id // Marca como Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usa o AUTO_INCREMENT do MySQL
    private Long id;

    private String nome;
    private String senha; // O hash da senha
}