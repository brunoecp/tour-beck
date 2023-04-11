package br.com.fiap.tourbeck.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.tourbeck.models.ContaEx;
import br.com.fiap.tourbeck.repository.ContaExRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    ContaExRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.saveAll(List.of(
        new ContaEx(1l, "Itau", new BigDecimal(100.00), "money"),
        new ContaEx(2l, "Santander", new BigDecimal(150.00), "monkey"),
        new ContaEx(3l, "Inter", new BigDecimal(75.00), "shark"),
        new ContaEx(4l, "c6", new BigDecimal(250.00), "bird")
        ));
    }
    
}
