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
import br.com.fiap.tourbeck.models.ContaEx;
import br.com.fiap.tourbeck.repository.ContaExRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/conta")
@Slf4j
public class ContaExController {
    
    @Autowired
    ContaExRepository repository;
    Logger log = LoggerFactory.getLogger(ContaExController.class);

    //GET ALL
    @GetMapping
    public Page<ContaEx> Home(Pageable pag){
        return repository.findAll(pag);
    }
    //GET
    @GetMapping("{id}")
    public ResponseEntity<ContaEx> show(@PathVariable Long id) {    
         return ResponseEntity.ok(getConta(id));
    }
    //POST 
    @PostMapping
    public ResponseEntity<ContaEx> create(@RequestBody @Valid ContaEx ContaEx, BindingResult result){
        log.info("Conta cadastrada " + ContaEx);
        repository.save(ContaEx);

        return ResponseEntity.status(HttpStatus.CREATED).body(ContaEx);
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<ContaEx> delete(@PathVariable Long id) {
        log.info("apagando Conta: " + id);
        repository.delete(getConta(id));
        return ResponseEntity.noContent().build();
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<ContaEx> update(@PathVariable Long id, @RequestBody @Valid ContaEx conta) {
        getConta(id);

        conta.setId(id);
        
        repository.save(conta);
        return ResponseEntity.ok(conta);
    }

    private ContaEx getConta(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Conta não encontrada"));
    }
}
