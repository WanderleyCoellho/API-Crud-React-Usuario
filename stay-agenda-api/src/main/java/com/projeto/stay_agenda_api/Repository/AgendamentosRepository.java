package com.projeto.stay_agenda_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.stay_agenda_api.Models.AgendamentosModel;

public interface AgendamentosRepository extends JpaRepository<AgendamentosModel, Long> {

}
