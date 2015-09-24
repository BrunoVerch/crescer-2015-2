

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
    public void elfoCriadoComFlechasNegativas(){
        Elfo elfo6=new Elfo("elfo5",-1);
        
        assertEquals(-1,elfo6.getFlechas());
    }
    @Test
    public void elfoAtiraFlechaGanhaXPPerdeFlechas(){
        Elfo elfo2= new Elfo("elfo1");
        Dwarf dwarf=new Dwarf("dwarf");
        
        elfo2.atirarFlecha(dwarf);
        
        assertEquals(41, elfo2.getFlechas());
        assertEquals(1, elfo2.getExperiencia());
        assertEquals(100.0, dwarf.getVida(), 0.5);
    }
    @Test
    public void elfoAtiraEmDoisAnoes(){
        Elfo elfo5= new Elfo("elfo4");
        Dwarf dwarf=new Dwarf("dwarf");
        Dwarf dwarf1=new Dwarf("dwarf1");
        
        elfo5.atirarFlecha(dwarf);
        elfo5.atirarFlecha(dwarf1);
        
        assertEquals(40, elfo5.getFlechas());
        assertEquals(2, elfo5.getExperiencia());
        assertEquals(100.0, dwarf.getVida(),0.5);
        assertEquals(100.0, dwarf1.getVida(),0.5);
    }
    @Test
    public void doisElfosAtiramEmDoisAnoes(){
        Elfo elfo5= new Elfo("elfo4");
        Elfo elfo6= new Elfo("elfo4");
        Dwarf dwarf=new Dwarf("dwarf");
        Dwarf dwarf1=new Dwarf("dwarf1");
        
        elfo5.atirarFlecha(dwarf);
        elfo5.atirarFlecha(dwarf1);
        elfo6.atirarFlecha(dwarf);
        elfo6.atirarFlecha(dwarf1);
        
        assertEquals(40, elfo5.getFlechas());
        assertEquals(40, elfo6.getFlechas());
        assertEquals(2, elfo5.getExperiencia());
        assertEquals(2, elfo6.getExperiencia());
        assertEquals(90, dwarf.getVida(),0.01);
        assertEquals(90, dwarf1.getVida(),0.01);
    }
    @Test
    public void elfoCriadoSomenteComNome(){
        Elfo elfo3= new Elfo("elfo2");
        
        assertEquals("elfo2", elfo3.getNome());
        assertNotNull(elfo3.getNome());
        assertEquals(42, elfo3.getFlechas());
        assertNotNull(elfo3.getFlechas());
    }
    @Test
    public void elfoCriado0DeExperiencia(){
        Elfo elfo7=new Elfo("elfo6");
        assertEquals(0, elfo7.getExperiencia());
    }
    @Test
    public void elfoCriadoComNomeNull(){
        Elfo elfo4=new Elfo(null);
        
        assertNull(elfo4.getNome());
    }
    @Test
    public void elfoComNomeEDozeFlechasToString(){
        Elfo elfo4=new Elfo("elfo3",12);
        assertEquals("elfo3 possui 12 flechas e 0 niveis de experiência",elfo4.toString());
    }
    @Test
    public void elfoComNomeEUmaFlechaToString(){
        Elfo elfo4=new Elfo("elfo3",1);
        assertEquals("elfo3 possui 1 flecha e 0 niveis de experiência",elfo4.toString());
    }
    @Test
    public void elfoComUmDeExperienciaToString(){
        Elfo elfo4=new Elfo("elfo3");
        elfo4.atirarFlecha(new Dwarf("dwarf"));
        assertEquals("elfo3 possui 41 flechas e 1 nivel de experiência",elfo4.toString());
    }
    @Test
    public void elfoNasceVivo(){
        Elfo elfo1=new Elfo("elfo1");
        
        assertEquals(Status.VIVO, elfo1.getStatus());
    }
    @Test
    public void elfoTemInventario(){
        Elfo elfo=new Elfo("elfo");
        elfo.getInventario().adicionarItem(new Item("espada",2));
        assertEquals(2,elfo.getInventario().getListaItens().get(0).getQuantidade());
        assertEquals("espada",elfo.getInventario().getListaItens().get(0).getDescricao());
    }
    @Test
    public void elfoCriadoTresVezesConta(){
        for(int i=0;i<6;i++){
            new Elfo("elfo");
        }
        Elfo elfo=new Elfo("sj");
        assertEquals(7,elfo.getCount());
    }
    @Before
    public void setUp(){
        Elfo.resetaCount();
    }
    
}
