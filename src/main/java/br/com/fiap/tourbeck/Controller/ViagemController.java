package br.com.fiap.tourbeck.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.models.Item;
import br.com.fiap.tourbeck.models.ListaItens;
import br.com.fiap.tourbeck.models.Viagem;

@RestController
public class ViagemController {

    ListaItens li = new ListaItens();

    List<Item> itens = new ArrayList<>();
    List<Viagem> viagens = new ArrayList<>();

    @GetMapping("/api/teste/viagem")
    public Viagem casa(){
        return new Viagem("Florianopolis", "Latam", new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar(2023, 2,10).getTime()), new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar(2023, 2,20).getTime()), li.Itens() );
    }
    @GetMapping("/api/v1/viagem")
    public List<Viagem> Home(){
        return viagens;
    }
    @GetMapping("api/v1/viagem/{id}")
    public ResponseEntity<Viagem> show(@PathVariable Long id) {
         var viagem = viagens.stream().filter(d -> d.getId().equals(id)).findFirst();

         if ( viagem.isEmpty()) return ResponseEntity.notFound().build();
         
         return ResponseEntity.ok(viagem.get());
    }
}