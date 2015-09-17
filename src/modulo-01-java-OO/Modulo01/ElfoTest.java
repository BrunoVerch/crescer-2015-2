

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoCriadoComFlechasENome(){
        Elfo elfo1 = new Elfo("elfo", 25);

        assertEquals("elfo", elfo1.getNome());
        assertNotNull(elfo1.getNome());
        assertEquals(25, elfo1.getFlechas());
        assertEquals(0, elfo1.getExperiencia());
    }
    @Test
    public void elfoAtiraFlechaGanhaXPPerdeFlechas(){
        Elfo elfo2= new Elfo("elfo1",22);
        
        elfo2.atirarFlecha(new Dwarf());
        assertEquals(21, elfo2.getFlechas());
        assertEquals(1, elfo2.getExperiencia());
    }
    @Test
    public void elfoCriadoSomenteComNome(){
        Elfo elfo3= new Elfo("elfo2");
        
        assertEquals("elfo2", elfo3.getNome());
        assertNotNull(elfo3.getNome());
        assertEquals(42, elfo3.getFlechas());
        assertNotNull(elfo3.getFlechas());
        assertEquals(0, elfo3.getExperiencia());
    }
}
