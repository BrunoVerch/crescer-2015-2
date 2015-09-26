

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNormalTest
{
    @Test
    public void exercitoCom4ElfosAtaca4DwarvesEVidaDwarfIgual70(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("1");
        ElfoVerde elfo2 = new ElfoVerde("2");
        ElfoVerde elfo3 = new ElfoVerde("3");
        ElfoVerde elfo4 = new ElfoVerde("4");
        
        Dwarf d1 = new Dwarf("e1");
        Dwarf d2 = new Dwarf("e2");
        Dwarf d3 = new Dwarf("e3");
        Dwarf d4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        dwarves.add(d4);
        
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(70, dwarves.get(0).getVida(),0.01);
        assertEquals(70, dwarves.get(1).getVida(),0.01);
        assertEquals(70, dwarves.get(2).getVida(),0.01);
        assertEquals(70, dwarves.get(3).getVida(),0.01);
    }
    @Test
    public void exercitoCom4ElfosAtaca4DwarvesEFicamCom38Flechas(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("1");
        ElfoVerde elfo2 = new ElfoVerde("2");
        ElfoVerde elfo3 = new ElfoVerde("3");
        ElfoVerde elfo4 = new ElfoVerde("4");
        
        Dwarf d1 = new Dwarf("e1");
        Dwarf d2 = new Dwarf("e2");
        Dwarf d3 = new Dwarf("e3");
        Dwarf d4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        dwarves.add(d4);
        
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(38, elfo1.getFlechas());
        assertEquals(38, elfo1.getFlechas());
        assertEquals(38, elfo1.getFlechas());
        assertEquals(38, elfo1.getFlechas());
    }
    @Test
    public void exercitoCom2ElfosVerdesAtaca2Vezes4Dwarves(){
        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde elfo1 = new ElfoVerde("1");
        ElfoVerde elfo2 = new ElfoVerde("2");
        
        Dwarf d1 = new Dwarf("e1");
        Dwarf d2 = new Dwarf("e2");
        Dwarf d3 = new Dwarf("e3");
        Dwarf d4 = new Dwarf("e4");
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        dwarves.add(d4);
        
        exercito.getEstrategia().atacar(exercito, dwarves);
        exercito.getEstrategia().atacar(exercito, dwarves);
        
        assertEquals(70, dwarves.get(0).getVida(),0.01);
        assertEquals(70, dwarves.get(1).getVida(),0.01);
        assertEquals(70, dwarves.get(2).getVida(),0.01);
        assertEquals(70, dwarves.get(3).getVida(),0.01);
    }
    @Test
   public void exercitoDeElfosAtacaEOsNoturnosSóAtacam2Vezes(){
       ExercitoElfos exercitoElfo = new ExercitoElfos();
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("ciclope");
       ElfoNoturno noturno3 = new ElfoNoturno("jean"); 
       
       exercitoElfo.alistarElfo(elfoVerde);
       exercitoElfo.alistarElfo(noturno);
       exercitoElfo.alistarElfo(noturno2);
       exercitoElfo.alistarElfo(noturno3);
       
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       dwarves.add(anao1);
       dwarves.add(anao2);
       
       int vidaAnaoEsperada = 90;
       
       ArrayList<Elfo> ordemAtaqueEsperada = new ArrayList<>(Arrays.asList(elfoVerde, noturno3));
       
       exercitoElfo.getEstrategia().atacar(exercitoElfo,dwarves);
       
       assertEquals(vidaAnaoEsperada,anao1.getVida(),0.01);              
       assertEquals(2,exercitoElfo.getEstrategia().ordemDoUltimoAtaque().size());
       assertEquals(ordemAtaqueEsperada,exercitoElfo.getEstrategia().ordemDoUltimoAtaque());
       
       
    } 
}
