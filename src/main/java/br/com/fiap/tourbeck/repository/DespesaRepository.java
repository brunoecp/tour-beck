package br.com.fiap.tourbeck.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.tourbeck.models.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

    Page<Despesa> findByDescricaoContaining(String busca, Pageable pag);
    
}
