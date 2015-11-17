package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionaPrimeiroNaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void adicionaUltimoNaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addLast("terceiro");
        assertEquals(linkedList.getFirst(), "segundo");
        assertEquals(linkedList.getLast(), "terceiro");
    }

    @Test
    public void listar() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addLast("terceiro");
        assertTrue(linkedList.list().contains("segundo"));
    }

    @Test
    public void removeTerceiro() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.remove(2);
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }
    @Test
    public void removePrimeiro() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.removeFirst();
        assertEquals(linkedList.getFirst(), "segundo");
        assertEquals(linkedList.getLast(), "primeiro");
    }
    @Test
    public void adicionaNaPosicao2() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.adicionar(2, "novo");
        assertEquals(linkedList.getNode(2).getValue(),"novo");
    }
    @Test
    public void verificaSeEstaVazio(){
    	LinkedList linkedList = new LinkedList();
    	assertTrue(linkedList.isEmpty());
    }
    @Test
    public void pegaPrimeiroDaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        assertEquals(linkedList.getFirst(), "segundo");
    }
    @Test
    public void pegaUltimoDaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        assertEquals(linkedList.getLast(), "primeiro");
    }

}
