import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    @Test
    public void dwarfReceberFlechada(){
        Dwarf dwarf1 = new Dwarf();
        dwarf1.receberFlechada();
        assertEquals(100, dwarf1.getVida());
    }
}
