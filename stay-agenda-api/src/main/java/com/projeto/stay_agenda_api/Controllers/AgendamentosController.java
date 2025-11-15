package com.projeto.stay_agenda_api.Controllers;

import com.projeto.stay_agenda_api.Models.AgendamentosModel; 
import com.projeto.stay_agenda_api.Repository.AgendamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendamentos") 
public class AgendamentosController {

    @Autowired
    private AgendamentosRepository agendamentoRepository;

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentosModel criarAgendamento(@RequestBody AgendamentosModel agendamento) {
      
        return agendamentoRepository.save(agendamento);
    }

   
    @GetMapping
    public List<AgendamentosModel> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentosModel> buscarAgendamentoPorId(@PathVariable Long id) {
        Optional<AgendamentosModel> agendamento = agendamentoRepository.findById(id);

        if (agendamento.isPresent()) {
            return ResponseEntity.ok(agendamento.get());
        }
        
        return ResponseEntity.notFound().build();
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<AgendamentosModel> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentosModel agendamentoDetalhes) {
        
        Optional<AgendamentosModel> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        AgendamentosModel agendamentoExistente = agendamentoOptional.get();
        
        agendamentoExistente.setData(agendamentoDetalhes.getData());
        agendamentoExistente.setHoraInicial(agendamentoDetalhes.getHoraInicial());
        agendamentoExistente.setHoraFinal(agendamentoDetalhes.getHoraFinal());
        agendamentoExistente.setObservacoes(agendamentoDetalhes.getObservacoes());
        agendamentoExistente.setStatus(agendamentoDetalhes.getStatus());
        agendamentoExistente.setValorParcial(agendamentoDetalhes.getValorParcial());
        agendamentoExistente.setValorProcedimento(agendamentoDetalhes.getValorProcedimento());

        agendamentoExistente.setClientes(agendamentoDetalhes.getClientes());
        agendamentoExistente.setProcedimentos(agendamentoDetalhes.getProcedimentos());
        

        AgendamentosModel agendamentoAtualizado = agendamentoRepository.save(agendamentoExistente);
        return ResponseEntity.ok(agendamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAgendamento(@PathVariable Long id) {
        
        if (!agendamentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        agendamentoRepository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}