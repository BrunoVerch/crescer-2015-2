

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
    public void elfoAtiraDuasVezesFlechasGanhaXPPerdeFlechas(){
        Elfo elfo5= new Elfo("elfo4",3);
        elfo5.atirarFlecha(new Dwarf());
        assertEquals(2, elfo5.getFlechas());
        assertEquals(1, elfo5.getExperiencia());
        elfo5.atirarFlecha(new Dwarf());
        assertEquals(1, elfo5.getFlechas());
        assertEquals(2, elfo5.getExperiencia());
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
    @Test
    public void testeToString(){
        Elfo elfo4=new Elfo("elfo3",12);
        assertEquals("elfo3 possui 12 flechas e 0 niveis de experiencia",elfo4.toString());
    }
}
