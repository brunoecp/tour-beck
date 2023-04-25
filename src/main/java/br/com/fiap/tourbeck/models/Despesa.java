package br.com.fiap.tourbeck.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.fiap.tourbeck.Controller.ContaExController;
import br.com.fiap.tourbeck.Controller.ExController;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
@Builder
public class Despesa{

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Min(0)
    private BigDecimal valor;
    @NotNull @PastOrPresent
    private LocalDate data;
    @NotBlank @Size(min= 5, max = 255)
    private String descricao;
    @ManyToOne
    private ContaEx conta;

    public EntityModel<Despesa> toEntityModel() {
        return EntityModel.of( 
            this,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExController.class).show(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExController.class).delete(id)).withRel("delete"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExController.class).Home(null, Pageable.unpaged())).withRel("all"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ContaExController.class).show(this.getConta().getId())).withRel("conta")
            );
    }
    
}
