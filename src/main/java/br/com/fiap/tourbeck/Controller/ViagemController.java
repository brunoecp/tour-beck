package br.com.fiap.tourbeck.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import br.com.fiap.tourbeck.models.Viagem;
import br.com.fiap.tourbeck.repository.UsuarioRepository;
import br.com.fiap.tourbeck.repository.ViagemRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/viagem")
public class ViagemController {

    @Autowired
    ViagemRepository viagemRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PagedResourcesAssembler<Object> assembler;
    Logger log = LoggerFactory.getLogger(ViagemController.class);

    //GET ALL
    @GetMapping
    public PagedModel<EntityModel<Object>> Home(Pageable pag, @RequestParam(required = false) String busca){
        Page<Viagem> viagens= (busca == null) ?
            viagemRepository.findAll(pag): 
            viagemRepository.findByAgenciaContaining(busca, pag);

        return assembler.toModel(viagens.map(Viagem::toEntityModel));
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<Viagem> show(@PathVariable Long id) {
         return ResponseEntity.ok(getViagem(id));
    }

    //POST 
    @PostMapping
    public ResponseEntity<Viagem> create(@RequestBody @Valid Viagem viagem, BindingResult result){
        log.info("inserindo viagem: " + viagem);

        viagemRepository.save(viagem);

        viagem.setUsuario(usuarioRepository.findById(viagem.getUsuario().getId()).get());

        return ResponseEntity.status(HttpStatus.CREATED).body(viagem);
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Viagem> delete(@PathVariable Long id) {

        log.info("Deletando viagem: " + id);

         viagemRepository.delete(getViagem(id));

         return ResponseEntity.noContent().build();
    }
    //PUT
    @PutMapping("{id}")
    public ResponseEntity<Viagem> update(@PathVariable Long id, @RequestBody Viagem viagem) {

        log.info("Atualizando viagem: " + id);

        getViagem(id);

        viagem.setId(id);

        viagemRepository.save(viagem);

        return ResponseEntity.ok(viagem);
    }
    
    private Viagem getViagem(Long id) {
        return viagemRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Viagem não encontrada"));
    }
}