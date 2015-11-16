package br.com.cwi.crescer;

import java.util.List;

public class DoublyLinkedList implements IList {

    private Nodo last, first;

    @Override
    public void addFirst(String value) {
        Nodo node = new Nodo(value, first, last);
        if (first == null) {
            last = node;
        }
        first = node;
    }

    @Override
    public void addLast(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub

    }

    @Override
    public void adicionar(int index, String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<String> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    private class Nodo {

        private String value;
        private Nodo next, previous;

        public Nodo(String value, Nodo next, Nodo previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
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
