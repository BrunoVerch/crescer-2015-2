

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SnagaTest
{
   @Test
    public void criadoSnaga(){
        Snaga orc = new Snaga();
        double vidaEsperada = 70.0;
        Item itemEsperado1 = new Item("Arco",1);
        Item itemEsperado2 = new Item("Flecha",5);
        assertEquals(vidaEsperada, orc.getVida(),0.5);
        assertEquals(itemEsperado1, orc.getInventario().getItemPorDescricao("Arco"));
        assertEquals(itemEsperado2, orc.getInventario().getItemPorDescricao("Flecha"));
    }
    @Test
    public void snagaRecebeAtaque(){
        Snaga orc = new Snaga();
        double vidaEsperada = 60.0;
        orc.levarAtaque();
        assertEquals(vidaEsperada, orc.getVida(),0.5);
    }
    @Test
    public void snagaMorre(){
        Snaga orc = new Snaga();
        double vidaEsperada = 0.0;
        for(int i = 0; i < 10; i++){
            orc.levarAtaque();
        }
        assertEquals(vidaEsperada, orc.getVida(),0.5);
        assertEquals(Status.MORTO, orc.getStatus());
    }
}
