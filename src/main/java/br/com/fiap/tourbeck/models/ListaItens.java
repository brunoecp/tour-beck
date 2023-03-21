package br.com.fiap.tourbeck.models;

import java.util.ArrayList;

public class ListaItens {

    public ArrayList<Item> Itens() {
        ArrayList<Item> i = new ArrayList<>();
        i.add(new Item("Meia", 2));
        i.add(new Item("Calça", 3));
        System.out.println(i.get(0));
        return i;
    }
}
