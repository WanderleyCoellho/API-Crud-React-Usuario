package com.projeto.stay_agenda_api.Controllers;

import com.projeto.stay_agenda_api.Models.MapeamentosModel;
import com.projeto.stay_agenda_api.Repository.MapeamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mapeamentos")
public class MapeamentosController {

    @Autowired
    private MapeamentosRepository mapeamentoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MapeamentosModel criarMapeamento(@RequestBody MapeamentosModel mapeamento) {
        return mapeamentoRepository.save(mapeamento);
    }

    
    @GetMapping
    public List<MapeamentosModel> listarMapeamentos() {
        return mapeamentoRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MapeamentosModel> buscarMapeamentoPorId(@PathVariable Long id) {
        Optional<MapeamentosModel> mapeamento = mapeamentoRepository.findById(id);

        if (mapeamento.isPresent()) {
            return ResponseEntity.ok(mapeamento.get());
        }
        
        return ResponseEntity.notFound().build();
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<MapeamentosModel> atualizarMapeamento(@PathVariable Long id, @RequestBody MapeamentosModel mapeamentoDetalhes) {
        
        Optional<MapeamentosModel> mapeamentoOptional = mapeamentoRepository.findById(id);

        if (mapeamentoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        MapeamentosModel mapeamentoExistente = mapeamentoOptional.get();
        
        mapeamentoExistente.setDescricao(mapeamentoDetalhes.getDescricao());
        mapeamentoExistente.setImagem(mapeamentoDetalhes.getImagem());
        mapeamentoExistente.setProcedimentos(mapeamentoDetalhes.getProcedimentos());
        mapeamentoExistente.setAgendamentos(mapeamentoDetalhes.getAgendamentos());
        mapeamentoExistente.setClientes(mapeamentoDetalhes.getClientes());

        MapeamentosModel mapeamentoAtualizado = mapeamentoRepository.save(mapeamentoExistente);
        return ResponseEntity.ok(mapeamentoAtualizado);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarMapeamento(@PathVariable Long id) {
        
        if (!mapeamentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        mapeamentoRepository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}