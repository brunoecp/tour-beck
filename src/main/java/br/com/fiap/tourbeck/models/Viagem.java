package br.com.fiap.tourbeck.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

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
    @NotBlank @FutureOrPresent
    private Date ida;
    @NotBlank @Future
    private Date Volta;

    public Viagem() {
    }
    
    public Viagem(Long id, String destino, String agencia, Date ida, Date volta) {
        this.id = id;
        this.destino = destino;
        this.agencia = agencia;
        this.ida = ida;
        Volta = volta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getIda() {
        return ida;
    }

    public void setIda(Date ida) {
        this.ida = ida;
    }

    public Date getVolta() {
        return Volta;
    }

    public void setVolta(Date volta) {
        Volta = volta;
    }

    @Override
    public String toString() {
        return "Viagem [id=" + id + ", destino=" + destino + ", agencia=" + agencia + ", ida=" + ida + ", Volta="
                + Volta + "]";
    }

}


