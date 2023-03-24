package br.com.fiap.tourbeck.models;

import java.util.ArrayList;
import java.util.List;

public class Viagem {
    
    private String destino;
    private String agencia;
    private String Id;
    private String Volta;
    private List<Item> itens;

    public Viagem() {
    }

    public Viagem(String destino, String agencia, String id, String volta, List<Item> itens) {
        this.destino = destino;
        this.agencia = agencia;
        Id = id;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVolta() {
        return Volta;
    }

    public void setVolta(String volta) {
        Volta = volta;
    }
    
    
    @Override
    public String toString() {
        return "Viagem [destino=" + destino + ", agencia=" + agencia + ", Ida=" + Id + ", Volta=" + Volta + ", itens="
                + itens + "]";
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }




}


