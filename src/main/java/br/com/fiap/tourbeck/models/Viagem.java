package br.com.fiap.tourbeck.models;

import java.util.ArrayList;
import java.util.List;

public class Viagem {
    
    private Long id;
    private String destino;
    private String agencia;
    private String ida;
    private String Volta;

    public Viagem() {
    }

    public Viagem(Long id, String destino, String agencia, String ida, String volta) {
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

    public String getIda() {
        return ida;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }

    public String getVolta() {
        return Volta;
    }

    public void setVolta(String volta) {
        Volta = volta;
    }

    @Override
    public String toString() {
        return "Viagem [id=" + id + ", destino=" + destino + ", agencia=" + agencia + ", ida=" + ida + ", Volta="
                + Volta + "]";
    }


}


