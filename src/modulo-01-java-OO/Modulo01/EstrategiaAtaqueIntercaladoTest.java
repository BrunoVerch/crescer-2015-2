

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest
{
    @Test
    public void exercitoCompostoPorNumeroImparDeElfosNaoIntercalam(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("5ghij");
        ElfoVerde elfo2 = new ElfoVerde("1");
        ElfoNoturno elfo3=new ElfoNoturno("2b");
        ElfoVerde elfo4 = new ElfoVerde("5ghj");
        ElfoNoturno elfo5=new ElfoNoturno("6klmno");
        
        
        Dwarf dwarf1 = new Dwarf("e1");
        Dwarf dwarf2 = new Dwarf("e2");
        Dwarf dwarf3 = new Dwarf("e3");
        Dwarf dwarf4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        dwarves.add(dwarf3);
        dwarves.add(dwarf4);
        
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(110, dwarf1.getVida(),0.01);
        assertEquals(110, dwarf2.getVida(),0.01);
        assertEquals(110, dwarf3.getVida(),0.01);
        assertEquals(110, dwarf4.getVida(),0.01);
    }
    @Test
    public void exercitoCompostoPor50PorCentoElfosVerdesE50PorCentoElfosNoturnos(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("5ghij");
        ElfoVerde elfo2 = new ElfoVerde("1");
        ElfoNoturno elfo3=new ElfoNoturno("2b");
        ElfoVerde elfo4 = new ElfoVerde("5ghj");
        ElfoNoturno elfo5=new ElfoNoturno("6klmno");
        ElfoNoturno elfo6=new ElfoNoturno("6klmo");
        
        
        Dwarf dwarf1 = new Dwarf("e1");
        Dwarf dwarf2 = new Dwarf("e2");
        Dwarf dwarf3 = new Dwarf("e3");
        Dwarf dwarf4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        exercito.alistarElfo(elfo6);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        dwarves.add(dwarf3);
        dwarves.add(dwarf4);
        
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(50, dwarf1.getVida(),0.01);
        assertEquals(50, dwarf2.getVida(),0.01);
        assertEquals(50, dwarf3.getVida(),0.01);
        assertEquals(50, dwarf4.getVida(),0.01);
    }
    @Test
    public void exercitoCompostoPorNumeroParMasNao50PorCentoElfosVerdesE50PorCentoElfosNoturnos(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("5ghij");
        ElfoVerde elfo2 = new ElfoVerde("1");
        ElfoNoturno elfo3=new ElfoNoturno("2b");
        ElfoNoturno elfo4 = new ElfoNoturno("5ghj");
        ElfoNoturno elfo5=new ElfoNoturno("6klmno");
        ElfoNoturno elfo6=new ElfoNoturno("6klmo");
        
        
        Dwarf dwarf1 = new Dwarf("e1");
        Dwarf dwarf2 = new Dwarf("e2");
        Dwarf dwarf3 = new Dwarf("e3");
        Dwarf dwarf4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        exercito.alistarElfo(elfo6);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        dwarves.add(dwarf3);
        dwarves.add(dwarf4);
        
        exercito.mudarEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(110, dwarf1.getVida(),0.01);
        assertEquals(110, dwarf2.getVida(),0.01);
        assertEquals(110, dwarf3.getVida(),0.01);
        assertEquals(110, dwarf4.getVida(),0.01);
    }
}
