package br.com.fiap.tourbeck.Controller.models;

import java.util.ArrayList;

public class ListaItens {

    public ArrayList<Item> itens() {
        ArrayList<Item> i = new ArrayList<>();
        i.add(new Item("Meia", 2));

        return i;
    }
}
