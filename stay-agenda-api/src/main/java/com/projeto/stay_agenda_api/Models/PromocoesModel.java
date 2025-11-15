package com.projeto.stay_agenda_api.Models;

import java.math.BigDecimal;

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
@Table(name = "promocoes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PromocoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataInicio;
    private String dataFim;
    private String descricao;
    BigDecimal valorPromocional;
    private String statusPromocao;

    
    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private ProcedimentosModel procedimento;
}
