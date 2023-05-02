package br.com.fiap.tourbeck.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.Exception.RestNotFoundException;
import br.com.fiap.tourbeck.models.Usuario;
import br.com.fiap.tourbeck.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;
    @Autowired
    PagedResourcesAssembler<Object> assembler;

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping
    public PagedModel<EntityModel<Object>> home(@RequestParam(required = false) String busca, Pageable pag) {
        Page<Usuario> usuarios= (busca == null) ?
        repository.findAll(pag): 
        repository.findByNomeContaining(busca, pag);
        return assembler.toModel(usuarios.map(Usuario::toEntityModel));
    }
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        return ResponseEntity.ok(getUsuario(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
        log.info("inserindo usuario: " + usuario);
        
        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        repository.delete(getUsuario(id));

        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        getUsuario(id);

        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }
    private Usuario getUsuario(Long id) {
        return repository.findById(id).orElseThrow(()-> new RestNotFoundException("Usuario não encontrado"));
    }
}
