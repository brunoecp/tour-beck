package br.com.fiap.tourbeck.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tourbeck.Controller.models.Despesa;

@RestController
public class DespesasController {
    

    @GetMapping("/api/v1/despesas")
    public Despesa Home(){
        return new Despesa(1l, new BigDecimal(100), LocalDate.now(), "Monkey");
    }
}
