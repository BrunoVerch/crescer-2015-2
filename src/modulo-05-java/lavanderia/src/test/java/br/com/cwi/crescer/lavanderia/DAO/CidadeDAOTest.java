package br.com.cwi.crescer.lavanderia.DAO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import br.com.cwi.crescer.lavanderia.domain.Cidade;


public class CidadeDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private CidadeDAO cidadeDao;

    @Test
    public void testFindById() throws Exception {
        Cidade cidade = cidadeDao.findById(1L);
        Assert.notNull(cidade);
    }

}
