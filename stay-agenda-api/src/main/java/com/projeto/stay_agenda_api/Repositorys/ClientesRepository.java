package com.projeto.stay_agenda_api.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.stay_agenda_api.Models.ClientesModel;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Integer> {

}
