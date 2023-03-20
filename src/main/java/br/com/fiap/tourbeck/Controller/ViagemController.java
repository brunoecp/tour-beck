package br.com.fiap.tourbeck.Controller;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.Controller.models.ListaItens;
import br.com.fiap.tourbeck.Controller.models.Viagem;

@RestController
public class ViagemController {

    ListaItens li = new ListaItens();

    @GetMapping("/api/v1/viagem")
    public Viagem Home(){
        return new Viagem("Florianopolis", "Latam", new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar(2021, 2,10).getTime()), new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar(2021, 2,20).getTime()), li.itens());
    }
}
