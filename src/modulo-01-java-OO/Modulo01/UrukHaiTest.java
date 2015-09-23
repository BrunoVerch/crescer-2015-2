

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrukHaiTest
{
    @Test
    public void criaUrukHai(){
        UrukHai orc = new UrukHai();
        int vidaEsperada = 150;
        Item itemEsperado = new Item("Escudo Uruk-Hai",1);
        Item itemEsperado1 = new Item("Espada",1);
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(itemEsperado, orc.getInventario().getItemPorDescricao("Escudo Uruk-Hai"));
        assertEquals(itemEsperado1, orc.getInventario().getItemPorDescricao("Espada"));
    }
    @Test
    public void urukHaiAtacaDwarf(){
        UrukHai orc = new UrukHai();
        Dwarf gimli = new Dwarf("Gimli");
        int vidaEsperada = 98;
        orc.atacarAnao(gimli);
        assertEquals(vidaEsperada, gimli.getVida());
    }
    @Test
    public void urukHaiRecebeDanoDeElfo(){
        UrukHai orc = new UrukHai();
        Elfo elfo = new Elfo("elfo");
        int vidaEsperada = 144;
        orc.levarAtaque();
        assertEquals(vidaEsperada, orc.getVida());
    }
}
