package br.com.fiap.tourbeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.tourbeck.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
