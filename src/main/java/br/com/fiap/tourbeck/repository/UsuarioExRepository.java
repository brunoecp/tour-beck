package br.com.fiap.tourbeck.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.tourbeck.models.UsuarioEx;

public interface UsuarioExRepository extends JpaRepository<UsuarioEx, Long>{

    Optional findByEmail(String email);
    
}
