package br.com.fiap.tourbeck.Controller;

import java.util.ArrayList;
import java.util.List;

import org.jboss.jandex.TypeTarget.Usage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.models.Usuario;

@RestController
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/api/v1/usuario")
    public List<Usuario> home() {
        return usuarios;
    }
    @GetMapping("/api/v1/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        var usuario = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (usuario.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuario.get());
    }
    @PostMapping("/api/v1/usuario/{i}")
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
        log.info("inserindo usuario: " + usuario);
        
        usuario.setId(usuarios.size() + 1l);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @DeleteMapping("/api/v1/usuario/{i}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        var usuario = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (usuario.isEmpty()) return ResponseEntity.notFound().build();

        usuarios.remove(usuario.get());

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/api/v1/usuario/{i}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        var usuarioEncontrado = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (usuarioEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        usuario.setId(id);
        usuarios.remove(usuarioEncontrado.get());
        usuarios.add(usuario);

        return ResponseEntity.ok(usuario);
    }
}
