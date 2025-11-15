package com.projeto.stay_agenda_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.stay_agenda_api.Models.ProcedimentosModel;

public interface ProcedimentosRepository extends JpaRepository<ProcedimentosModel, Long> {

}
