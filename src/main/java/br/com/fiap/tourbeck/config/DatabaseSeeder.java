package br.com.fiap.tourbeck.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.tourbeck.models.ContaEx;
import br.com.fiap.tourbeck.models.Usuario;
import br.com.fiap.tourbeck.models.Viagem;
import br.com.fiap.tourbeck.repository.ContaExRepository;
import br.com.fiap.tourbeck.repository.UsuarioRepository;
import br.com.fiap.tourbeck.repository.ViagemRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ContaExRepository contaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ViagemRepository viagemRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario u = new Usuario(1l, "brunin", "masculino", "bruedu@gmail.com", "são paulo");

        ContaEx c1 = new ContaEx(1l, "Itau", new BigDecimal(100.00), "money");
        ContaEx c2 = new ContaEx(2l, "Santander", new BigDecimal(150.00), "monkey");
        ContaEx c3 = new ContaEx(3l, "Inter", new BigDecimal(75.00), "shark");
        ContaEx c4 = new ContaEx(4l, "c6", new BigDecimal(250.00), "bird");
        ContaEx c5 = new ContaEx(5l, "Banco do Brasil", new BigDecimal(850.00), "fishcat");

        contaRepository.saveAll(List.of(
                c1,
                c2,
                c3,
                c4,
                c5));
        usuarioRepository.saveAll(List.of(
                u,
                new Usuario(2l, "zezin", "masculino", "zedobreu@gmail.com", "são joao"),
                new Usuario(3l, "robertin", "masculino", "robertao@gmail.com", "são cristovao"),
                new Usuario(4l, "mariruana", "feminino", "aipapito@gmail.com", "são pedro")));

        viagemRepository.saveAll(List.of(
                new Viagem(1L, "japao", "latam", new Date(2023, 4, 13), new Date(2023, 4, 20), u),
                new Viagem(2L, "Alemanha", "Avianca", new Date(2023, 4, 15), new Date(2023, 4, 22), u),
                new Viagem(3L, "Vaticano", "agencia nova", new Date(2023, 4, 17), new Date(2023, 4, 25), u),
                new Viagem(4L, "Italia", "PassDe", new Date(2023, 4, 21), new Date(2023, 4, 28), u)));
    }

}