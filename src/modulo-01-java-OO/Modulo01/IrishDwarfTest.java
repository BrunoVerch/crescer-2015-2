

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfTentarSorteGanha1000(){
        IrishDwarf irish=new IrishDwarf("te",new DataTerceiraEra(1,1,2016));
        irish.receberFlechada();
        irish.receberFlechada();
        irish.getInventario().adicionarItem(new Item("espada",1));
        irish.getInventario().adicionarItem(new Item("escudo",3));
        irish.tentarSorte();
        assertEquals(1002,irish.getInventario().getListaItens().get(0).getQuantidade());
        assertEquals(6009,irish.getInventario().getListaItens().get(1).getQuantidade());
    }
    @Test
    public void irishDwarfTentarSorteCom0Itens(){
        IrishDwarf irish=new IrishDwarf("te",new DataTerceiraEra(1,1,2016));
        irish.receberFlechada();
        irish.receberFlechada();
        irish.getInventario().adicionarItem(new Item("espada",0));
        irish.tentarSorte();
        assertEquals(0,irish.getInventario().getListaItens().get(0).getQuantidade());
    }
    @Test
    public void irishDwarfTentarSorteCom1ItemNaoSendoAnoBissexto(){
        IrishDwarf irish=new IrishDwarf("te");
        irish.receberFlechada();
        irish.receberFlechada();
        irish.getInventario().adicionarItem(new Item("espada",3));
        irish.tentarSorte();
        assertEquals(3,irish.getInventario().getListaItens().get(0).getQuantidade());
    }
}
