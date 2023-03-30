package br.com.fiap.tourbeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.tourbeck.models.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
    
}
