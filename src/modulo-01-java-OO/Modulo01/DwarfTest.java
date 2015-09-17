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
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    @Test
    public void dwarfReceberFlechadaEPerde10Vida(){
        Dwarf dwarf1 = new Dwarf();
        dwarf1.receberFlechada();
        assertEquals(100, dwarf1.getVida());
    }
    @Test
    public void dwarfReceberFlechada11vezesVidaIgual0(){
        Dwarf dwarf2 = new Dwarf();
        for(int i=0;i<11;i++){
            dwarf2.receberFlechada();
        }
        assertEquals(0, dwarf2.getVida());
    }
    @Test
    public void dwarfReceberFlechada7vezesEVidaIgual40(){
        Dwarf dwarf3 = new Dwarf();
        for(int i=0;i<7;i++){
            dwarf3.receberFlechada();
        }
        assertEquals(40, dwarf3.getVida());
    }
    @Test
    public void dwarfComVidaZeroStatusMorto(){
        Dwarf dwarf1=new Dwarf();
        for(int i=0;i<11;i++){
            dwarf1.receberFlechada();
        }
        assertEquals(Status.MORTO,dwarf1.getStatus());
    }
    @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf1=new Dwarf();
        
        assertEquals(Status.VIVO, dwarf1.getStatus());
    }
}
