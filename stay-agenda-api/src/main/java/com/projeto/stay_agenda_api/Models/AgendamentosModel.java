package com.projeto.stay_agenda_api.Models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "agendamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private String horaInicial;
    private String horaFinal;
    private String Observacoes;
    private String status;
    private BigDecimal valorParcial;
    private BigDecimal valorProcedimento;


    @OneToMany(mappedBy = "agendamentos")
    private List <MapeamentosModel> mapeamentos;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientesModel clientes;

    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private ProcedimentosModel procedimentos;

}
