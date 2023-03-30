package br.com.fiap.tourbeck.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Viagem> Home(){
        return repository.findAll();
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<Viagem> show(@PathVariable Long id) {
         var viagem = repository.findById(id);

         if ( viagem.isEmpty()) return ResponseEntity.notFound().build();
         
         return ResponseEntity.ok(viagem.get());
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

        var viagem = repository.findById(id);

         if ( viagem.isEmpty()) return ResponseEntity.notFound().build();

         repository.delete(viagem.get());

         return ResponseEntity.noContent().build();
    }
    //PUT
    @PutMapping("{id}")
    public ResponseEntity<Viagem> update(@PathVariable Long id, @RequestBody Viagem viagem) {

        log.info("Atualizando viagem: " + id);

        var viagemEncontrada = repository.findById(id);

        if ( viagemEncontrada.isEmpty()) return ResponseEntity.notFound().build();

        viagem.setId(id);

        repository.save(viagem);

        return ResponseEntity.ok(viagem);
    }
}