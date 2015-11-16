package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList implements IList {

    private Nodo last, first;

    @Override
    public void addFirst(String value) {
        Nodo node = new Nodo(value, first);
        if (first == null) {
            last = node;
        }
        first = node;
    }

    @Override
    public void addLast(String value) {
        Nodo node = new Nodo(value, last);
        if (first == null) {
            first = node;
        }
        last = node;
    }

    @Override
    public void removeFirst() {
        Nodo node = first.getNext();
        this.first = node;
    }

    @Override
    public void adicionar(int index, String value) {
        Nodo novo = new Nodo(value);
        Nodo atual = getNode(index);
        Nodo anterior = getNode(index - 1);
        novo.next = atual;
        anterior.next = novo;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void remove(int index) {
        Nodo tmp = getNode(index - 1);
        Nodo removido = tmp.getNext();
        tmp.setNext(removido.getNext());
    }

    private Nodo getNode(int index) {
        Nodo node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    @Override
    public List<String> list() {
        ArrayList<String> lista = new ArrayList<String>();
        Nodo node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    private class Nodo {

        private String value;
        private Nodo next;

        public Nodo(String value, Nodo node) {
            this.value = value;
            this.next = node;
        }

        public Nodo(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Nodo getNext() {
            return next;
        }

        public void setNext(Nodo next) {
            this.next = next;
        }
    }
}