

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
   @Test
   public void elfoVerdeAtacaDwarf(){
       ElfoVerde elfo=new ElfoVerde("elfo");
       Dwarf dwarf=new Dwarf();
       elfo.atirarFlecha(dwarf);
       
       assertEquals(2,elfo.getExperiencia());
    }
   @Test
   public void elfoVerdeAdicionaEspadaValiriano(){
       ElfoVerde elfo=new ElfoVerde("elfo");
       elfo.adicionarItem(new Item("Espada de aço valiriano",1));
       Inventario esperado = new Inventario();
       esperado.adicionarItem(new Item("Espada de aço valiriano",1));
        
       assertEquals(esperado, elfo.getInventario());
   }
   @Test
   public void elfoVerdeAdicionaItemDescricaoInvalida(){
       ElfoVerde elfo=new ElfoVerde("elfo");
       elfo.adicionarItem(new Item("Espada",1));
       Inventario esperado = new Inventario();
       assertEquals(esperado,elfo.getInventario());
   }
   @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroEDescricaoNula() {
        ElfoVerde elfo = new ElfoVerde("elfo");
        elfo.adicionarItem(new Item("Arco e flecha de vidro",1));
        elfo.adicionarItem(new Item(null,1));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Arco e flecha de vidro",1));
        assertEquals(esperado,elfo.getInventario());
   }
   @Test
   public void elfoVerdeAdicionaEspadaValirianoENulo(){
       ElfoVerde elfo = new ElfoVerde("elfo");
       elfo.adicionarItem(new Item("Espada de aço valiriano",1));
       elfo.adicionarItem(null);
       Inventario esperado = new Inventario();
       esperado.adicionarItem(new Item("Espada de aço valiriano",1));
       assertEquals(esperado,elfo.getInventario());
   }
}
