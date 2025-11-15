package com.projeto.stay_agenda_api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "mapeamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapeamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private byte[] imagem;

    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private ProcedimentosModel procedimentos;
    
    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    private AgendamentosModel agendamentos;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientesModel clientes;
    
}
