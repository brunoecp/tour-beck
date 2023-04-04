package br.com.fiap.tourbeck.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.Exception.RestNotFoundException;
import br.com.fiap.tourbeck.models.Despesa;
import br.com.fiap.tourbeck.repository.DespesaRepository;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/despesas")
public class ExController {
    
    @Autowired
    DespesaRepository repository;
    Logger log = LoggerFactory.getLogger(ExController.class);

    //GET ALL
    @GetMapping
    public Page<Despesa> Home(Pageable pag){
        return repository.findAll(pag);
    }
    //GET
    @GetMapping("{id}")
    public ResponseEntity<Despesa> show(@PathVariable Long id) {    
         return ResponseEntity.ok(getDespesa(id));
    }
    //POST 
    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody @Valid Despesa despesa, BindingResult result){
        log.info("despesa cadastrada " + despesa);
        repository.save(despesa);

        return ResponseEntity.status(HttpStatus.CREATED).body(despesa);
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Despesa> delete(@PathVariable Long id) {
        log.info("apagando despesa: " + id);
        repository.delete(getDespesa(id));
        return ResponseEntity.noContent().build();
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody @Valid Despesa despesa) {
        getDespesa(id);

        despesa.setId(id);
        
        repository.save(despesa);
        return ResponseEntity.ok(despesa);
    }

    private Despesa getDespesa(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Despesa não encontrada"));
    }
}
