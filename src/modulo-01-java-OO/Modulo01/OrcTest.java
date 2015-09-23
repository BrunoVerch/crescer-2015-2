

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcTest
{
    @Test
    public void criaOrcEStatusVivoEInventarioCriado(){
        Orc orc=new Orc();
        Inventario esperado=new Inventario();
        assertEquals(Status.VIVO,orc.getStatus());
        assertEquals(esperado,orc.getInventario());
    }
}
