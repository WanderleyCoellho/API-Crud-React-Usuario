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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "procedimentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedimentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    // --- Relacionamento --- Um procedimento tem uma unica categoria
    @ManyToOne
    // Foreign Key/Chave Estrangeira --- ou seja a coluna que referencia a outra tabela
    @JoinColumn(name = "categoria_id")
    private CategoriasModel categoria;


    @OneToMany(mappedBy = "procedimento")
    private List<PromocoesModel> promocao;

    @OneToMany(mappedBy = "procedimentos")
    private List<MapeamentosModel> mapeamentos;

    @OneToMany(mappedBy = "procedimentos")
    private List<AgendamentosModel> agendamentos;

    private String procedimento;
    private String descricao;
    private BigDecimal valor;

}
