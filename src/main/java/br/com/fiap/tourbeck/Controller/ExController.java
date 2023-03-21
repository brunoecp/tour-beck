package br.com.fiap.tourbeck.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.models.Despesa;

@RestController
public class ExController {
    
    Logger log = LoggerFactory.getLogger(ExController.class);

    List<Despesa> despesas = new ArrayList<>();

    //GET ALL
    @GetMapping("/api/v1/despesas")
    public List<Despesa> Home(){
        return despesas;
    }
    //GET
    @GetMapping("api/v1/despesas/{id}")
    public ResponseEntity<Despesa> show(@PathVariable Long id) {
         var despesa = despesas.stream().filter(d -> d.getId().equals(id)).findFirst();

         if ( despesa.isEmpty()) return ResponseEntity.notFound().build();
         
         return ResponseEntity.ok(despesa.get());
    }
    //POST 
    @PostMapping("/api/v1/despesas")
    public ResponseEntity<Despesa> create(@RequestBody Despesa despesa){
        log.info("despesa cadastrada " + despesa);
        despesas.add(despesa);

        return ResponseEntity.status(HttpStatus.CREATED).body(despesa);
    }

    //DELETE
    @DeleteMapping("/api/v1/despesas/{id}")
    public ResponseEntity<Despesa> delete(@PathVariable Long id) {
        var despesa = despesas.stream().filter(d -> d.getId().equals(id)).findFirst();

        if ( despesa.isEmpty()) return ResponseEntity.notFound().build();

        despesas.remove(despesa.get());
        return ResponseEntity.noContent().build();
    }

    //UPDATE
    @PutMapping("/api/v1/despesas/{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa) {
        var despesaExistente = despesas.stream().filter(d -> d.getId().equals(id)).findFirst();

        if ( despesaExistente.isEmpty()) return ResponseEntity.notFound().build();

        despesa.setId(id);
        despesas.remove(despesaExistente.get());
        despesas.add(despesa);
        return ResponseEntity.ok(despesa);
    }
}
