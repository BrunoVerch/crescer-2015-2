

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
}
