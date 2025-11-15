package com.projeto.stay_agenda_api.Controllers;

import com.projeto.stay_agenda_api.Repository.PromocoesRepository;
import com.projeto.stay_agenda_api.Models.PromocoesModel; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promocoes") 
public class PromocoesController {

    @Autowired
    private PromocoesRepository promocaoRepository;

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PromocoesModel criarPromocao(@RequestBody PromocoesModel promocao) {
        
        return promocaoRepository.save(promocao);
    }

    @GetMapping
    public List<PromocoesModel> listarPromocoes() {
        return promocaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromocoesModel> buscarPromocaoPorId(@PathVariable Long id) {
        Optional<PromocoesModel> promocao = promocaoRepository.findById(id);

        if (promocao.isPresent()) {
            return ResponseEntity.ok(promocao.get());
        }
        
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromocoesModel> atualizarPromocao(@PathVariable Long id, @RequestBody PromocoesModel promocaoDetalhes) {
        
        Optional<PromocoesModel> promocaoOptional = promocaoRepository.findById(id);

        if (promocaoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PromocoesModel promocaoExistente = promocaoOptional.get();
        
        promocaoExistente.setDataInicio(promocaoDetalhes.getDataInicio());
        promocaoExistente.setDataFim(promocaoDetalhes.getDataFim());
        promocaoExistente.setDescricao(promocaoDetalhes.getDescricao());
        promocaoExistente.setValorPromocional(promocaoDetalhes.getValorPromocional());
        promocaoExistente.setStatusPromocao(promocaoDetalhes.getStatusPromocao());
        promocaoExistente.setProcedimento(promocaoDetalhes.getProcedimento());

        PromocoesModel promocaoAtualizada = promocaoRepository.save(promocaoExistente);
        return ResponseEntity.ok(promocaoAtualizada);
    }

  
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPromocao(@PathVariable Long id) {
        
        if (!promocaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        promocaoRepository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}