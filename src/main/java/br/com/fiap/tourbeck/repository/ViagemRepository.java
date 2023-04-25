package br.com.fiap.tourbeck.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.tourbeck.models.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long>{

    public Page<Viagem> findByAgenciaContaining(String busca, Pageable pag);
    
}
