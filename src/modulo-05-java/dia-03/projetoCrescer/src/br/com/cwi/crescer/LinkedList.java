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
        if (!isEmpty()) {
            if (first.next == null) {
                first = null;
            } else {
                first = first.next;
            }
    	}
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
    	Nodo anterior = getNode(index-1);
        Nodo atual = anterior.getNext();
        anterior.setNext(atual.getNext());
    }

    public Nodo getNode(int index) {
        Nodo node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public String getFirst() {
        return (String) first.getValue();
    }

    @Override
    public String getLast() {
        return (String) last.getValue();
    }

    @Override
    public List<String> list() {
        ArrayList<String> lista = new ArrayList<String>();
        Nodo node = first;
        while (node != null) {
            lista.add((String) node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    public class Nodo<T> {

        private T value;
        private Nodo next;

        public Nodo(T value, Nodo node) {
            this.value = value;
            this.next = node;
        }

        public Nodo(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
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
