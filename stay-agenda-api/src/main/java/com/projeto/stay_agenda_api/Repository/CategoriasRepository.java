package com.projeto.stay_agenda_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.stay_agenda_api.Models.CategoriasModel;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriasModel, Long> {

}
