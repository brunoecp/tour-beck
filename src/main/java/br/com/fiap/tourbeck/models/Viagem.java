package br.com.fiap.tourbeck.models;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.fiap.tourbeck.Controller.UsuarioController;
import br.com.fiap.tourbeck.Controller.ViagemController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "T_TBE_VIAGEM")
public class Viagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String destino;
    @NotBlank
    private String agencia;
    @NotNull @FutureOrPresent
    private Date ida;
    @NotNull @Future
    private Date volta;
    @ManyToOne
    private Usuario usuario;

    public EntityModel<Viagem> toEntityModel() {
        return EntityModel.of( 
            this,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ViagemController.class).show(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ViagemController.class).delete(id)).withRel("delete"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ViagemController.class).Home( Pageable.unpaged(),null)).withRel("all"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).show(this.getUsuario().getId())).withRel("Usuario")
            );
    }
}


