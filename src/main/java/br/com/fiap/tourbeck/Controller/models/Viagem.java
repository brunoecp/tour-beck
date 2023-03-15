package br.com.fiap.tourbeck.Controller.models;

import java.util.Date;
import java.util.List;

public class Viagem {
    
    private String destino;
    private String agencia;
    private Date Ida;
    private Date Volta;
    private List<Item> itens;

    public Viagem() {
    }

    public Viagem(String destino, String agencia, Date ida, Date volta, List<Item> itens) {
        this.destino = destino;
        this.agencia = agencia;
        Ida = ida;
        Volta = volta;
        this.itens = itens;
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
        return Ida;
    }
    public void setIda(Date ida) {
        Ida = ida;
    }
    public Date getVolta() {
        return Volta;
    }
    public void setVolta(Date volta) {
        Volta = volta;
    }
    public List<Item> getItens() {
        return itens;
    }
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Viagem [destino=" + destino + ", agencia=" + agencia + ", Ida=" + Ida + ", Volta=" + Volta + ", itens="
                + itens + "]";
    }
    
}


