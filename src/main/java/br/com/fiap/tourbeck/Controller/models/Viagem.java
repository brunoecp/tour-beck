package br.com.fiap.tourbeck.Controller.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Viagem {
    
    private String destino;
    private String agencia;
    private String Ida;
    private String Volta;
    private ArrayList<Item> itens;

    public Viagem() {
    }
    
    public Viagem(String destino, String agencia, String ida, String volta, ArrayList<Item> itens) {
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


    public String getIda() {
        return Ida;
    }

    public void setIda(String ida) {
        Ida = ida;
    }

    public String getVolta() {
        return Volta;
    }

    public void setVolta(String volta) {
        Volta = volta;
    }
    
    @Override
    public String toString() {
        return "Viagem [destino=" + destino + ", agencia=" + agencia + ", Ida=" + Ida + ", Volta=" + Volta + ", itens="
                + itens + "]";
    }
}


