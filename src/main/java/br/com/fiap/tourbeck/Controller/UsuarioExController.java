package br.com.fiap.tourbeck.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.models.Credencial;
import br.com.fiap.tourbeck.models.Usuario;
import br.com.fiap.tourbeck.models.UsuarioEx;
import br.com.fiap.tourbeck.repository.UsuarioExRepository;
import jakarta.validation.Valid;

@RestController

public class UsuarioExController {

    @Autowired
    UsuarioExRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;
    
    @PostMapping("/api/registrar")
    public ResponseEntity<UsuarioEx> registrar(@RequestBody @Valid UsuarioEx usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Credencial> login(@RequestBody Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
    
        return ResponseEntity.ok().build();
    }
}
