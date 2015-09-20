

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
    @Test
    public void inventarioOrdenarItens(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",8);
        Item item1=new Item("espada",1);
        Item item2=new Item("poçao",5);
        Item item3=new Item("mapa",2);
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        
        lista.ordenarItens();
        
        assertEquals(1,lista.getListaItens().get(0).getQuantidade());
        assertEquals(item3,lista.getListaItens().get(1));
    }
    @Test
    public void inventarioOrdenarItensComAlgunsValoresNegativos(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",8);
        Item item1=new Item("espada",1);
        Item item2=new Item("poçao",-5);
        Item item3=new Item("mapa",-2);
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        
        lista.ordenarItens();
        
        assertEquals(-5,lista.getListaItens().get(0).getQuantidade());
        assertEquals(item3,lista.getListaItens().get(1));
    }
    @Test
    public void inventarioOrdenarItensComItensJaOrdenados(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",1);
        Item item1=new Item("espada",2);
        Item item2=new Item("poçao",3);
        Item item3=new Item("mapa",4);
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        
        lista.ordenarItens();
        
        assertEquals(1,lista.getListaItens().get(0).getQuantidade());
        assertEquals(item1,lista.getListaItens().get(1));
    }
    @Test
    public void inventarioOrdenarItensComPerdasAntesEDepois(){
        Inventario lista=new Inventario();
        Item item=new Item("escudo",9);
        Item item1=new Item("espada",2);
        Item item2=new Item("poçao",3);
        Item item3=new Item("cantil",7);
        Item item4=new Item("mapa",4);
        lista.adicionarItem(item);
        lista.adicionarItem(item1);
        lista.adicionarItem(item2);
        lista.adicionarItem(item3);
        lista.adicionarItem(item4);
        lista.perderItem(item2);
        
        lista.ordenarItens();
        lista.perderItem(item1);
        
        assertEquals(4,lista.getListaItens().get(0).getQuantidade());
        assertEquals(item3,lista.getListaItens().get(1));
    }
}
