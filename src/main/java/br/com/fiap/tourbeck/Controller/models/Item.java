package br.com.fiap.tourbeck.Controller.models;

public class Item {

    private String nome;
    private Integer quantidade;
    
    public Item(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Item() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Itens [nome=" + nome + ", quantidade=" + quantidade + "]";
    }
    
}
