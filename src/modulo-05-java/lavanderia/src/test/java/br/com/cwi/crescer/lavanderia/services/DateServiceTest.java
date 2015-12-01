package br.com.cwi.crescer.lavanderia.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateServiceTest {

	@Test
    public void ehDeSegundaAQuarta() throws ParseException {
        DateService service = new DateService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("04/11/2015");
        
        boolean resposta = service.ehDeSegundaAQuarta(date);
        
        assertTrue(resposta);       
    }
    
	@Test
    public void ehQuintaOuSexta() throws ParseException {
        DateService service = new DateService();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("04/12/2015");
        
        boolean resposta = service.ehQuintaOuSexta(date);
        
        assertTrue(resposta);       
    }
	
	@Test
    public void naoEhQuintaOuSextaEhSabado() throws ParseException {
        DateService service = new DateService();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("05/12/2015");
        
        boolean resposta = service.ehQuintaOuSexta(date);
        
        assertFalse(resposta);       
    }
}
