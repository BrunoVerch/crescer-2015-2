

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataTerceiraEraTest
{
    @Test
    public void dataEhBissexto(){
        DataTerceiraEra data=new DataTerceiraEra(29,02,2012);
        
        boolean anoBissexto=data.ehBissexto();
        assertTrue(anoBissexto);
    }
    @Test
    public void dataNaoEhBissexto(){
        DataTerceiraEra data=new DataTerceiraEra(25,02,2013);
        
        boolean anoNaoBissexto=data.ehBissexto();
        assertFalse(anoNaoBissexto);
    }
    @Test
    public void dataCriadaComTodosAtributos(){
        DataTerceiraEra data=new DataTerceiraEra(13,06,2005);
        
        assertEquals(13,data.getDia());
        assertEquals(06,data.getMes());
        assertEquals(2005,data.getAno());
    }
    @Test
    public void dataCriadaComTodosAtributosEDia0(){
        DataTerceiraEra data=new DataTerceiraEra(0,06,2005);
        
        assertEquals(0,data.getDia());
        assertEquals(06,data.getMes());
        assertEquals(2005,data.getAno());
    }
    
}
