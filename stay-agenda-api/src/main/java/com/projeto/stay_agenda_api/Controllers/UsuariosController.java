package com.projeto.stay_agenda_api.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import com.projeto.stay_agenda_api.Models.UsuariosModel;
import com.projeto.stay_agenda_api.Repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;



//@CrossOrigin(origins = "http://localhost:5173") //Permite requisições CORS do frontend rodando em localhost:5173

@RestController //Diz ao Spring que esta classe é um "Controlador" de API
@RequestMapping("/api/usuarios") //Define a URL base para esta classe

public class UsuariosController {

    //Injeção de Dependência: O Spring vai "injetar" (fornecer) 
    //uma instância do nosso UsuarioRepository aqui.
    @Autowired
    private UsuariosRepository usuarioRepository;

    // --- CREATE (POST) ---
    // URL: POST /api/usuarios
    @PostMapping
    public UsuariosModel criarUsuario(@RequestBody UsuariosModel usuario) {

        //Aqui entra a lógica de "hashear" a senha antes de salvar
        String senhaHasheada = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());

        usuario.setSenha(senhaHasheada);
        
        return usuarioRepository.save(usuario); 
    }

    // --- READ (GET) ---
    // URL: GET /api/usuarios
    @GetMapping
    public List<UsuariosModel> listarUsuarios() {

        return usuarioRepository.findAll();
    }

    // --- READ (GET por ID) ---
    // URL: GET /api/usuarios/1 (ou /2, /3, etc.)
    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> buscarUsuarioPorId(@PathVariable Long id) {
        
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario)) // Se achar, retorna 200 OK
                .orElse(ResponseEntity.notFound().build()); // Se não achar, retorna 404 Not Found
    }

    // --- UPDATE (PUT) ---
    // URL: PUT /api/usuarios/1
    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> atualizarUsuario(@PathVariable Long id, @RequestBody UsuariosModel usuarioAtualizado) {
        
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNome(usuarioAtualizado.getNome());

                    // Aqui entra a lógica de "hashear" a nova senha
                    var senhaHasheada = BCrypt.hashpw(usuarioAtualizado.getSenha(), BCrypt.gensalt());

                    usuarioExistente.setSenha(senhaHasheada);
                    
                    usuarioExistente.setSenha(null);

                    UsuariosModel salvo = usuarioRepository.save(usuarioExistente);
                    
                    return ResponseEntity.ok().body(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // --- DELETE (DELETE) ---
    // URL: DELETE /api/usuarios/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.deleteById(id);
                    return ResponseEntity.ok().build(); // Retorna 200 OK (sem corpo)
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
