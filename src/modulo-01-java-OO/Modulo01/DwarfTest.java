import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    /*organizacao do teste 
     * AAA
     *Arrange
     *Act
     *Assert
    */
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf("dwarf");
        assertEquals(110, gimli.getVida());
    }
    @Test
    public void dwarfReceberFlechadaEPerde10Vida(){
        Dwarf dwarf1 = new Dwarf("dwarf");
        dwarf1.receberFlechada();
        assertEquals(100, dwarf1.getVida());
    }
    @Test
    public void dwarfReceberFlechada11vezesVidaIgual0(){
        Dwarf dwarf2 = new Dwarf("dwarf");
        for(int i=0;i<11;i++){
            dwarf2.receberFlechada();
        }
        assertEquals(0, dwarf2.getVida());
    }
    @Test
    public void dwarfReceberFlechada7vezesEVidaIgual40(){
        Dwarf dwarf3 = new Dwarf("dwarf");
        for(int i=0;i<7;i++){
            dwarf3.receberFlechada();
        }
        assertEquals(40, dwarf3.getVida());
    }
    @Test
    public void dwarfReceberFlechada7vezesEStatusVivo(){
        Dwarf dwarf3 = new Dwarf("dwarf");
        for(int i=0;i<7;i++){
            dwarf3.receberFlechada();
        }
        assertEquals(Status.VIVO,dwarf3.getStatus());
    }
    @Test
    public void dwarfComVidaZeroStatusMorto(){
        Dwarf dwarf1=new Dwarf("dwarf");
        for(int i=0;i<11;i++){
        dwarf1.receberFlechada();
        }
        assertEquals(Status.MORTO, dwarf1.getStatus());
    }
    @Test
    public void dwarfComVidaZeroStatusMortoEMaisUmaFlechada(){
        Dwarf dwarf1=new Dwarf("dwarf");
        for(int i=0;i<12;i++){
        dwarf1.receberFlechada();
        }
        assertEquals(Status.MORTO, dwarf1.getStatus());
        assertEquals(0,dwarf1.getVida());
    }
    @Test
    public void dwarfComVidaNegativa(){
        Dwarf dwarf1=new Dwarf("dwarf");
        for(int i=0;i<12;i++){
        dwarf1.receberFlechada();
        }
        assertEquals(0, dwarf1.getVida());
    }
    @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf1=new Dwarf("dwarf");
        
        assertEquals(Status.VIVO, dwarf1.getStatus());
    }
    @Test
    public void dwarfCriadoComNomeEDataPadrao(){
        Dwarf dwarf1=new Dwarf("dwarf");
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,1,1);

        assertEquals(dataEsperada,dwarf1.getDataNascimento());
    }
    @Test
    public void dwarfCriadoComData11Do03De2015(){
        Dwarf dwarf1=new Dwarf("dwarf",new DataTerceiraEra(11,03,2015));
        DataTerceiraEra dataNascimento = dwarf1.getDataNascimento();
        
        assertEquals("dwarf",dwarf1.getNome());
        assertEquals(11,dataNascimento.getDia());
        assertEquals(03,dataNascimento.getMes());
        assertEquals(2015,dataNascimento.getAno());
    }
    @Test
    public void dwarfCriadoNoAnoBissextoCom90DeVidaGetNumeroSorte(){
        Dwarf dwarf= new Dwarf("dwarf",new DataTerceiraEra(29,02,2012));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        assertEquals(-3333.0,dwarf.getNumeroSorte(),1.0);
        
    }
    @Test
    public void dwarfCriadoComNomeSeixasGetNumeroSorte(){
        Dwarf dwarf= new Dwarf("Seixas");
        assertEquals(33.3,dwarf.getNumeroSorte(),1.0);
        
    }
    @Test
    public void dwarfCriadoNoAnoBissextoGetNumeroSorte(){
        Dwarf dwarf= new Dwarf("dwarf",new DataTerceiraEra(29,02,2012));
        assertEquals(101.0,dwarf.getNumeroSorte(),1.0);
    }
    @Test
    public void dwarfCriadoRecebeFlechaEGetNumeroSorteMenorZero(){
        Dwarf dwarf= new Dwarf("dwarf",new DataTerceiraEra(29,02,2012));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        
        dwarf.receberFlechada();
       
        assertEquals(2,dwarf.getExperiencia());
        assertEquals(-3333.0,dwarf.getNumeroSorte(),0.5);
        assertEquals(90,dwarf.getVida());
    }
    @Test
    public void dwarfCriadoComNomeSeixasERecebeFlechaEGetNumeroSorteEntre0E100(){
        Dwarf dwarf= new Dwarf("Seixas");
      
        dwarf.receberFlechada();
        
        assertEquals(110,dwarf.getVida());
        assertEquals(33.3,dwarf.getNumeroSorte(),1.0);
    }
    @Test
    public void dwarfCriadoComNomeMeirelesERecebeFlechaEGetNumeroSorteEntre0E100(){
        Dwarf dwarf= new Dwarf("Meireles");
        
        dwarf.getNumeroSorte();
        dwarf.receberFlechada();
        
        assertEquals(110,dwarf.getVida());
        assertEquals(33.3,dwarf.getNumeroSorte(),1.0);
    }
    @Test
    public void dwarfReceberFlechadaNormal(){
        Dwarf dwarf=new Dwarf("gh");
        
        dwarf.receberFlechada();
        
        assertEquals(100,dwarf.getVida());
    }
}
