

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class EstrategiaNoturnosUltimosTest
{
    @Test
    public void exercitoDe3ElfosE3ElfosNoturnosAtacam3DwarvesEDwarvesFicamCom50DeVida(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("1");
        ElfoVerde elfo2 = new ElfoVerde("2");
        ElfoVerde elfo3 = new ElfoVerde("3");
        ElfoNoturno elfo4=new ElfoNoturno("4");
        ElfoNoturno elfo5=new ElfoNoturno("5");
        ElfoNoturno elfo6=new ElfoNoturno("6");
        
        Dwarf d1 = new Dwarf("e1");
        Dwarf d2 = new Dwarf("e2");
        Dwarf d3 = new Dwarf("e3");
        Dwarf d4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        exercito.alistarElfo(elfo6);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        dwarves.add(d4);
        
        exercito.mudarEstrategia(new EstrategiaNoturnosUltimos());
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(50, dwarves.get(0).getVida(),0.01);
        assertEquals(50, dwarves.get(1).getVida(),0.01);
        assertEquals(50, dwarves.get(2).getVida(),0.01);
        assertEquals(50, dwarves.get(3).getVida(),0.01);
    }
    @Test
    public void exercitoDe3ElfosVerdesE4ElfosNoturnosAtacam4DwarvesEVerificaSeNoturnosForamUltimos(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("1");
        ElfoNoturno elfo2=new ElfoNoturno("2b");
        ElfoVerde elfo3 = new ElfoVerde("3bc");
        ElfoNoturno elfo4=new ElfoNoturno("4def");
        ElfoVerde elfo5 = new ElfoVerde("5ghij");
        ElfoNoturno elfo6=new ElfoNoturno("6klmno");
        ElfoNoturno elfo7=new ElfoNoturno("7klmnot");
        
        ArrayList<Elfo> esperado=new ArrayList<>();
        esperado.add(elfo1);
        esperado.add(elfo3);
        esperado.add(elfo5);
        esperado.add(elfo2);
        esperado.add(elfo4);
        esperado.add(elfo6);
        esperado.add(elfo7);
        
        Dwarf d1 = new Dwarf("e1");
        Dwarf d2 = new Dwarf("e2");
        Dwarf d3 = new Dwarf("e3");
        Dwarf d4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        exercito.alistarElfo(elfo6);
        exercito.alistarElfo(elfo7);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        dwarves.add(d4);
        
        exercito.mudarEstrategia(new EstrategiaNoturnosUltimos());
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(esperado, exercito.getEstrategia().ordemDoUltimoAtaque());
    }
}
