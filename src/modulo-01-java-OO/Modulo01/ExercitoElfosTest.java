

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoElfosTest
{
    @Test
    public void exercitoCriadoAlistaElfoVerde(){
        ExercitoElfos exercito=new ExercitoElfos();
        ElfoVerde elfo=new ElfoVerde("elfo");
        HashMap <String,Elfo> esperado = new HashMap<>();
        esperado.put("elfo",elfo);
        
        exercito.alistarElfo(elfo);
        
        assertEquals(esperado,exercito.getExercito());
    }
    @Test
    public void exercitoCriadoAlistaElfoNoturno(){
        ExercitoElfos exercito=new ExercitoElfos();
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        HashMap <String,Elfo> esperado = new HashMap<>();
        esperado.put("elfo",elfo);
        
        exercito.alistarElfo(elfo);
        
        assertEquals(esperado,exercito.getExercito());
    }
    @Test
    public void exercitoCriadoAlistaElfoEBuscaElfo(){
        ExercitoElfos exercito=new ExercitoElfos();
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        
        exercito.alistarElfo(elfo);
        Elfo buscaElfo=exercito.buscarElfo(elfo);
        
        assertEquals(elfo,buscaElfo);
    }
    @Test
    public void exercitoCriadoAlistaElfosEAgrupaPorStatus(){
        ExercitoElfos exercito=new ExercitoElfos();
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        ElfoVerde elfo1=new ElfoVerde("elfo1");
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo1);
        ExercitoElfos esperado=new ExercitoElfos();
        esperado.alistarElfo(elfo);
        esperado.alistarElfo(elfo1);
        esperado.agruparPorStatus();
        
        
        exercito.agruparPorStatus();
        
        assertEquals(esperado,exercito);
    }
    @Test
    public void umElfoMortoAgruparPorStatus(){
       ExercitoElfos exercitoDeElfos = new ExercitoElfos();
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
       for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
       }
       exercitoDeElfos.alistarElfo(noturno);
       exercitoDeElfos.agruparPorStatus();
       assertEquals(noturno, exercitoDeElfos.buscar(Status.MORTO).get(0));
    }
    @Test
    public void tresElfosMortosEAgrupadosPorStatus(){
        ExercitoElfos exercito = new ExercitoElfos();
        ElfoNoturno noturno = new ElfoNoturno("Noturno 1", 100);
        ElfoNoturno noturno2 = new ElfoNoturno("Noturno 2", 100);
        ElfoNoturno noturno3 = new ElfoNoturno("Noturno 3", 100);
        for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
           noturno2.atirarFlecha(new Dwarf());
           noturno3.atirarFlecha(new Dwarf());
       }
        exercito.alistarElfo(noturno);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(noturno3);
        exercito.agruparPorStatus();
        assertEquals(noturno, exercito.buscar(Status.MORTO).get(0));
        assertEquals(noturno2, exercito.buscar(Status.MORTO).get(1));
        assertEquals(noturno3, exercito.buscar(Status.MORTO).get(2));
    }
    @Test
    public void elfoNaoAlistadoEChamado(){
        ExercitoElfos exercito = new ExercitoElfos();
        ElfoVerde elfo = new ElfoVerde("elfo");
        exercito.alistarElfo(elfo);
        assertEquals(null, exercito.getExercito().get("elfo2"));
    }
    @Test
    public void elfoAlistadosAgruparStatusContemElfosVivo(){
        ExercitoElfos exercito= new ExercitoElfos();
        ElfoVerde elfo1 = new ElfoVerde("elfo1");
        ElfoVerde elfo2 = new ElfoVerde("elfo2");
        ElfoVerde elfo3 = new ElfoVerde("elfo3");
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.agruparPorStatus();
        assertTrue(exercito.buscar(Status.VIVO).contains(elfo1));
        assertTrue(exercito.buscar(Status.VIVO).contains(elfo2));
        assertTrue(exercito.buscar(Status.VIVO).contains(elfo3));
    }
    @Test
   public void doisElfosMortosEDoisVivosAgrupadosPorStatus(){
      ExercitoElfos exercitoDeElfos = new ExercitoElfos();
      ElfoVerde green = new ElfoVerde("Fandango");
      ElfoVerde green2 = new ElfoVerde("Fandango1");
      ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
      ElfoNoturno noturno2 = new ElfoNoturno("Noturno II", 100);
      for(int i = 0; i < 99; i++){
          noturno.atirarFlecha(new Dwarf());
          noturno2.atirarFlecha(new Dwarf());
      }
      exercitoDeElfos.alistarElfo(green);
      exercitoDeElfos.alistarElfo(green2);
      exercitoDeElfos.alistarElfo(noturno);
      exercitoDeElfos.alistarElfo(noturno2);
      exercitoDeElfos.agruparPorStatus();
      
      assertTrue(exercitoDeElfos.buscar(Status.VIVO).contains(green));
      assertTrue(exercitoDeElfos.buscar(Status.VIVO).contains(green2));
      assertTrue(exercitoDeElfos.buscar(Status.MORTO).contains(noturno));
      assertTrue(exercitoDeElfos.buscar(Status.MORTO).contains(noturno2));
   }
}
