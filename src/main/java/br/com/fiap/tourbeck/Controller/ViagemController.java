package br.com.fiap.tourbeck.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.Exception.RestNotFoundException;
import br.com.fiap.tourbeck.models.Viagem;
import br.com.fiap.tourbeck.repository.ViagemRepository;

@RestController
@RequestMapping("/api/v1/viagem")
public class ViagemController {

    @Autowired
    ViagemRepository repository;
    Logger log = LoggerFactory.getLogger(ViagemController.class);

    //GET ALL
    @GetMapping
    public Page<Viagem> Home(Pageable paginacao){
        return repository.findAll(paginacao);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<Viagem> show(@PathVariable Long id) {
         return ResponseEntity.ok(getViagem(id));
    }

    //POST 
    @PostMapping
    public ResponseEntity<Viagem> create(@RequestBody Viagem viagem){
        log.info("inserindo viagem: " + viagem);

        repository.save(viagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(viagem);
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Viagem> delete(@PathVariable Long id) {

        log.info("Deletando viagem: " + id);

         repository.delete(getViagem(id));

         return ResponseEntity.noContent().build();
    }
    //PUT
    @PutMapping("{id}")
    public ResponseEntity<Viagem> update(@PathVariable Long id, @RequestBody Viagem viagem) {

        log.info("Atualizando viagem: " + id);

        getViagem(id);

        viagem.setId(id);

        repository.save(viagem);

        return ResponseEntity.ok(viagem);
    }
    
    private Viagem getViagem(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Viagem não encontrada"));
    }
}