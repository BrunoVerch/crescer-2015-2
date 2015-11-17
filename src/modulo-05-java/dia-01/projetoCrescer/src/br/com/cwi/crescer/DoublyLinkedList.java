package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList implements IList {

    private Nodo last, first;

    @Override
    public void addFirst(String value) {
    	Nodo novo = new Nodo(value, null, null);        
        if(first == null){
        	first = novo;
            last = first;
        } else {
        	first.setPrevious(novo);
        	novo.setNext(first);
            first = novo;
        }
    }

    @Override
    public void addLast(String value) {
    	Nodo novo = new Nodo(value, null, null);        
        if(first == null){
        	first = novo;
            last = first;
        } else {
        	novo.setPrevious(last);
        	last.setNext(novo);
            last = novo;
        }
    }

    @Override
    public void removeFirst() {
    	if (!isEmpty()) {
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                first = first.next;
                first.previous = null;
            }
    	}
    }

    @Override
    public void remove(int index) {
    	Nodo aSerRemovido = getNode(index);
    	Nodo anterior = aSerRemovido.getPrevious();
        Nodo proximo = aSerRemovido.getNext();
        anterior.setNext(proximo);
        proximo.setPrevious(anterior);
    }

    @Override
    public void adicionar(int index, String value) {
    	if (index == 1){
    		this.addFirst(value);
    		return;
    	}
    	Nodo node = getNode(index);
        Nodo proximo = node.getNext();
        Nodo novo = new Nodo(value, proximo, node);
        node.setNext(novo);
        proximo.setPrevious(novo);
    }
    
    private Nodo getNode(int index) {
        Nodo node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public boolean isEmpty() {
    	return (first == null);
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

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    private class Nodo <T> {

        private T value;
        private Nodo next, previous;

        public Nodo(T value, Nodo next, Nodo previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Nodo(T value) {
            this.value = value;
        }

        public String getValue() {
            return (String) value;
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
        
        public Nodo getPrevious() {
            return previous;
        }

        public void setPrevious(Nodo previous) {
            this.previous = previous;
        }
    }
}
