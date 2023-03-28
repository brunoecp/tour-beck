package br.com.fiap.tourbeck.models;

import java.util.ArrayList;

public class ListaItens {

    public ArrayList<Item> Itens() {
        ArrayList<Item> i = new ArrayList<>();
        i.add(new Item(1l,"Meia", 2));
        i.add(new Item(2l, "Calça", 3));
        return i;
    }
}
