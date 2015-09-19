

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
    @Test
    public void itemCriadoComDescricaoEQuantidade(){
        Item item=new Item("espada",5);
        assertEquals("espada",item.getDescricao());
        assertEquals(5,item.getQuantidade());
    }
    @Test
    public void itemCriadoAcrescenta1000Quantidade(){
        Item item=new Item("poçao",2);
        item.acrescenta1000();
        assertEquals(1002,item.getQuantidade());
    }
}
