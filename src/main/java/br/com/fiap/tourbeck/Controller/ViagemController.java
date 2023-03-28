package br.com.fiap.tourbeck.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import br.com.fiap.tourbeck.models.Viagem;

@RestController
public class ViagemController {

    SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");

    Logger log = LoggerFactory.getLogger(ViagemController.class);

    List<Viagem> viagens = new ArrayList<>();

    //GET ALL
    @GetMapping("/api/v1/viagem")
    public List<Viagem> Home(){
        return viagens;
    }

    //GET
    @GetMapping("api/v1/viagem/{id}")
    public ResponseEntity<Viagem> show(@PathVariable Long id) {
         var viagem = viagens.stream().filter(d -> d.getId().equals(id)).findFirst();

         if ( viagem.isEmpty()) return ResponseEntity.notFound().build();
         
         return ResponseEntity.ok(viagem.get());
    }

    //POST 
    @PostMapping("/api/v1/viagem")
    public ResponseEntity<Viagem> create(@RequestBody Viagem viagem){
        log.info("inserindo viagem: " + viagem);

        viagem.setId(viagens.size() + 1l);

        viagens.add(viagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(viagem);
    }

    //DELETE
    @DeleteMapping("/api/v1/viagem/{id}")
    public ResponseEntity<Viagem> delete(@PathVariable Long id) {

        log.info("Deletando viagem: " + id);

        var viagem = viagens.stream().filter(d -> d.getId().equals(id)).findFirst();

         if ( viagem.isEmpty()) return ResponseEntity.notFound().build();

         viagens.remove(viagem.get());

         return ResponseEntity.noContent().build();
    }
    //PUT
    @PutMapping("/api/v1/viagem/{id}")
    public ResponseEntity<Viagem> update(@PathVariable Long id, @RequestBody Viagem viagem) {

        log.info("Atualizando viagem: " + id);

        var viagemEncontrada = viagens.stream().filter(d -> d.getId().equals(id)).findFirst();

        if ( viagemEncontrada.isEmpty()) return ResponseEntity.notFound().build();

        viagens.remove(viagemEncontrada.get());
        viagem.setId(id);
        viagens.add(viagem);

        return ResponseEntity.ok(viagem);
    }
}