package br.com.fiap.tourbeck.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

import br.com.fiap.tourbeck.models.Despesa;
import br.com.fiap.tourbeck.repository.DespesaRepository;
import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/api/v1/despesas")
public class ExController {
    
    @Autowired
    DespesaRepository repository;
    Logger log = LoggerFactory.getLogger(ExController.class);

    //GET ALL
    @GetMapping
    public List<Despesa> Home(){
        return repository.findAll();
    }
    //GET
    @GetMapping("{id}")
    public ResponseEntity<Despesa> show(@PathVariable Long id) {
         var despesa = repository.findById(id);

         if ( despesa.isEmpty()) return ResponseEntity.notFound().build();
         
         return ResponseEntity.ok(despesa.get());
    }
    //POST 
    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody Despesa despesa){
        log.info("despesa cadastrada " + despesa);
        repository.save(despesa);

        return ResponseEntity.status(HttpStatus.CREATED).body(despesa);
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Despesa> delete(@PathVariable Long id) {
        var despesa = repository.findById(id);

        if ( despesa.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(despesa.get());
        return ResponseEntity.noContent().build();
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa) {
        var despesaExistente = repository.findById(id);

        if ( despesaExistente.isEmpty()) return ResponseEntity.notFound().build();

        despesa.setId(id);
        /*
        var despesaAtualizada = despesaExistente.get();

        BeanUtils.copyProperties(despesa, despesaExistente, "id");
        */
        
        repository.save(despesa);
        return ResponseEntity.ok(despesa);
    }
}
