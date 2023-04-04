package br.com.fiap.tourbeck.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Despesa {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Min(0)
    private BigDecimal valor;
    @NotNull @PastOrPresent
    private LocalDate data;
    @NotBlank @Size(min= 5, max = 255)
    private String descricao;

    public Despesa() {
    }

    public Despesa(Long id, BigDecimal valor, LocalDate data, String descricao) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Despesa [id=" + id + ", valor=" + valor + ", data=" + data + ", descricao=" + descricao + "]";
    }
    
    
}
