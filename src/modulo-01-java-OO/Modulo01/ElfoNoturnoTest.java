

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoAtiraFlechaEPerdePorcentagemVida(){
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        Dwarf dwarf=new Dwarf("dwarf");
        double vidaEsperada=95.0;
        
        elfo.atirarFlecha(dwarf);
        
        assertEquals(vidaEsperada,elfo.getVidaDouble(),0.001);
    }
    @Test
    public void elfoNoturnoAtiraFlechaDuasVezesEPerdePorcentagemVida(){
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        Dwarf dwarf=new Dwarf("dwarf");
        double vidaEsperada=90.25;
        
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        
        assertEquals(vidaEsperada,elfo.getVidaDouble(),0.001);
    }
    @Test
    public void elfoNoturnoAtiraFlechaGanha3Experiencia(){
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        Dwarf dwarf=new Dwarf("dwarf");
        
        elfo.atirarFlecha(dwarf);
        
        assertEquals(3,elfo.getExperiencia());
    }
    
}
