

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
        
        assertEquals(esperado,exercito.getHashMap());
    }
    @Test
    public void exercitoCriadoAlistaElfoNoturno(){
        ExercitoElfos exercito=new ExercitoElfos();
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        HashMap <String,Elfo> esperado = new HashMap<>();
        esperado.put("elfo",elfo);
        
        exercito.alistarElfo(elfo);
        
        assertEquals(esperado,exercito.getHashMap());
    }
    @Test
    public void exercitoCriadoAlistaElfoEBuscaElfo(){
        ExercitoElfos exercito=new ExercitoElfos();
        ElfoNoturno elfo=new ElfoNoturno("elfo");
        
        exercito.alistarElfo(elfo);
        Elfo buscaElfo=exercito.buscarElfo(elfo);
        
        assertEquals(elfo,buscaElfo);
    }
}
