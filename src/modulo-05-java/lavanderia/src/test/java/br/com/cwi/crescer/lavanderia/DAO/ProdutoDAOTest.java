package br.com.cwi.crescer.lavanderia.DAO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import br.com.cwi.crescer.lavanderia.domain.Produto;


public class ProdutoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ProdutoDAO produtoDao;

    @Test
    public void testFindById() throws Exception {
        Produto produto = produtoDao.findById(1L);
        Assert.notNull(produto);
        Assert.notNull(produto.getMaterial());
        Assert.notNull(produto.getServico());
    }

}
