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

import br.com.fiap.tourbeck.models.Item;

@RestController
public class ItemController {
    
    Logger log = LoggerFactory.getLogger(ItemController.class);

    List<Item> itens = new ArrayList<>();

    @GetMapping("/api/v1/item")
    public List<Item> home() {
        return itens;
    }
    @GetMapping("/api/v1/item/{id}")
    public ResponseEntity<Item> show(@PathVariable Long id) {
        var item = itens.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(item.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(item.get());
    }
    @PostMapping("/api/v1/item")
    public ResponseEntity<Item> insert(@RequestBody Item item) {
        log.info("inserindo item: " + item);

        item.setId(itens.size() + 1l);
        itens.add(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    @DeleteMapping("/api/v1/item/{id}")
    public ResponseEntity<Item> delete(@PathVariable Long id) {
        var item = itens.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(item.isEmpty()) return ResponseEntity.notFound().build();

        itens.remove(item.get());

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/api/v1/item/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
        var itemEncotrado = itens.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(itemEncotrado.isEmpty()) return ResponseEntity.notFound().build();
        
        itens.remove(itemEncotrado.get());
        item.setId(id);
        itens.add(item);

        return ResponseEntity.ok(item);
    }
}
