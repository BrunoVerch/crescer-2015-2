

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class InventarioTest
{
    @Test
    public void inventarioCriadoEAdicionaItem(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",3);
        Item item1=new Item("poçao",1);
        lista.adicionarItem(item);
        lista.adicionarItem(item1);

        assertEquals(lista.getListaItens().get(0),item);
        assertEquals(lista.getListaItens().get(1),item1);
    }
    @Test
    public void inventarioCriadoERemoveItem(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",3);
        Item item1=new Item("espada",5);
        Item item2=new Item("mapa",2);
        
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.perderItem(item1);
        lista.adicionarItem(item2);
        
        assertEquals(lista.getListaItens().get(0),item);
        assertEquals(lista.getListaItens().get(1),item2);
        assertEquals(2,lista.getListaItens().size());
    }
    @Test
    public void inventarioGetDescricoesItens(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",2);
        Item item1=new Item("espada",1);
        Item item2=new Item("poçao",5);
        Item item3=new Item("mapa",2);
        String esperado="escudo,espada,poçao,mapa";
        
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        
        assertEquals(esperado,lista.getDescricoesItens());
    }
    @Test
    public void inventarioGetDescricoesItensComPerderItem(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",2);
        Item item1=new Item("espada",1);
        Item item2=new Item("poçao",5);
        Item item3=new Item("mapa",2);
        String esperado="escudo,espada,mapa";
        
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        lista.perderItem(item2);
        
        assertEquals(esperado,lista.getDescricoesItens());
    }
    @Test
    public void inventarioGetItemComMaiorQuantidade(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",2);
        Item item1=new Item("espada",1);
        Item item2=new Item("poçao",5);
        Item item3=new Item("mapa",2);
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        
        assertEquals(item2,lista.getItemComMaiorQuantidade());
    }
    @Test
    public void inventarioComPrimeiroItemMaiorGetItemComMaiorQuantidade(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",8);
        Item item1=new Item("espada",1);
        Item item2=new Item("poçao",5);
        Item item3=new Item("mapa",2);
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        
        assertEquals(item,lista.getItemComMaiorQuantidade());
    }
    
}
