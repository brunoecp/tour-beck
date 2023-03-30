package br.com.fiap.tourbeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.tourbeck.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
