package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;


public class ItemDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ItemDAO itemDao;

    @Test
    public void testFindById() throws Exception {
        Item item = itemDao.findById(1L);
        Assert.assertNotNull(item);
    }

    @Test
    public void deveBuscarItensPendentes() throws Exception {
        List<Item> itens = itemDao.findBySituacao(SituacaoItem.PENDENTE);
        Assert.assertNotNull(itens);
        Assert.assertFalse(itens.isEmpty());

        for (Item item : itens) {
            Assert.assertEquals(SituacaoItem.PENDENTE, item.getSituacao());
        }
    }

}
