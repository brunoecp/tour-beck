package br.com.fiap.tourbeck.models;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.fiap.tourbeck.Controller.UsuarioController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "T_TBE_USUARIO")
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)    
        private Long id;
        @NotBlank 
        private String nome;
        @NotBlank
        private String sexo;
        @NotBlank
        private String Email;
        @NotBlank
        private String cidade;

        public EntityModel<Usuario> toEntityModel() {
            return EntityModel.of( 
                this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).show(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).delete(id)).withRel("delete"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).home(null, Pageable.unpaged())).withRel("all")
                );
        }
    }
