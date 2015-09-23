

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrukHaiTest
{
    @Test
    public void criaUrukHai(){
        UrukHai orc = new UrukHai();
        double vidaEsperada = 150.0;
        Item itemEsperado = new Item("Escudo Uruk-Hai",1);
        Item itemEsperado1 = new Item("Espada",1);
        
        assertEquals(vidaEsperada, orc.getVida(),0.5);
        assertEquals(itemEsperado, orc.getInventario().getItemPorDescricao("Escudo Uruk-Hai"));
        assertEquals(itemEsperado1, orc.getInventario().getItemPorDescricao("Espada"));
    }
    @Test
    public void urukHaiAtacaDwarf(){
        UrukHai orc = new UrukHai();
        Dwarf gimli = new Dwarf("Gimli");
        double vidaEsperada = 98.0;
        orc.atacarAnao(gimli);
        assertEquals(vidaEsperada, gimli.getVida(),0.5);
    }
    @Test
    public void urukHaiRecebeDanoDeElfo(){
        UrukHai orc = new UrukHai();
        double vidaEsperada = 144.0;
        orc.levarAtaque();
        assertEquals(vidaEsperada, orc.getVida(),0.5);
    }
}
