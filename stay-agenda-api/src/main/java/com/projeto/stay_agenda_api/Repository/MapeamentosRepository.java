package com.projeto.stay_agenda_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.stay_agenda_api.Models.MapeamentosModel;

public interface MapeamentosRepository extends JpaRepository<MapeamentosModel, Long> {

}
